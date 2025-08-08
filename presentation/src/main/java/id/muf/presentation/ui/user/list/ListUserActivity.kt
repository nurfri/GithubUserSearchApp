package id.muf.presentation.ui.user.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.muf.data.local.user.database.AppUserDatabase
import id.muf.data.repository.user.detail.DetailUserRepositoryImpl
import id.muf.data.repository.user.local.UserRepositoryImpl
import id.muf.domain.model.user.list.ListUser
import id.muf.domain.model.user.list.ListUserItem
import id.muf.domain.model.user.local.ListUserLocal
import id.muf.domain.usecase.user.detail.DetailUserUseCase
import id.muf.presentation.adapter.user.ListUserAdapter
import id.muf.presentation.databinding.ActivityUserListBinding
import id.muf.presentation.viewmodel.DetailUserViewModel
import id.muf.presentation.viewmodel.DetailUserViewModelFactory
import id.muf.presentation.viewmodel.ListUserViewModel
import id.muf.presentation.viewmodel.ListUserViewModelFactory

class ListUserActivity: AppCompatActivity() {
    companion object{
        var listUserItems = ArrayList<ListUserItem>()
        var usernames: String? = null
        fun launchIntent(caller: Activity?, username: String?, listUserItem: ArrayList<ListUserItem>){
            val intent = Intent(caller, ListUserActivity::class.java)
            caller?.startActivity(intent)
            listUserItems = listUserItem
            usernames = username
        }
    }

    var adapter: ListUserAdapter? = null
    var binding: ActivityUserListBinding? = null
    var viewModel: ListUserViewModel? = null
    var listUserLocal= ArrayList<ListUserLocal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.lifecycleOwner = this

        val db = AppUserDatabase.getDatabase(applicationContext)
        val userDao = db.userDao()
        val listUserRepository = UserRepositoryImpl(userDao)
        val listUserViewModelFactory = ListUserViewModelFactory(listUserRepository)
        viewModel = ViewModelProvider(this, listUserViewModelFactory)[ListUserViewModel::class.java]
        viewModel?.saveListUser(usernames, listUserItems)

        /*adapter = ListUserAdapter(this, listUserItems)
        binding?.rvUser?.adapter = adapter*/

        supportActionBar?.title = "List User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        filterText()
        responseDB()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflaterMenu = menuInflater
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //==============================================Edit Text Filter=============================================================
    fun filterText(){
        binding?.etFilterSearch?.doAfterTextChanged {
            p0 -> filter(p0.toString())
        }
    }

    //fungsi filter untuk di terapkan di recyclerView
    private fun filter(text: String) {
        //new array list that will hold the filtered data
        val filterdNames = ArrayList<ListUserLocal>()
        filterdNames.clear()

        //looping through existing elements
        for (s in listUserLocal) {
            //if the existing elements contains the search input
            if (s.username?.lowercase()?.contains(text.lowercase()) == true) {
                //adding the element to filtered list
                filterdNames.add(s)
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter?.filterList(filterdNames)
    }
    //=============================================================================================================================

    fun responseDB(){
        viewModel?._messageValue?.observe(this, Observer {
                t -> t.let {
            UIVisibility()
            listUserLocal = it
            adapter = ListUserAdapter(this, listUserLocal)
            binding?.rvUser?.adapter = adapter
        }
        })
    }

    fun UIVisibility(){
        if(binding?.pbUserList?.visibility == View.VISIBLE){
            binding?.pbUserList?.visibility = View.INVISIBLE
            binding?.etFilterSearch?.visibility = View.VISIBLE
            binding?.rvUser?.visibility = View.VISIBLE
        }
    }
}