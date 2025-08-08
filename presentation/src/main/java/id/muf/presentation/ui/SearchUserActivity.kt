package id.muf.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.muf.data.repository.user.list.ListUserRepositoryImpl
import id.muf.domain.usecase.user.list.ListUserUseCase
import id.muf.presentation.databinding.ActivityAppControlBinding
import id.muf.presentation.ui.user.list.ListUserActivity
import id.muf.presentation.viewmodel.SearchUserViewModel
import id.muf.presentation.viewmodel.SearchUserViewModelFactory

class SearchUserActivity: AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        when(p0){
            binding?.btnSubmitSearch ->{
                binding?.pbSearchUser?.visibility = View.VISIBLE
                viewModel?.fetchAppControl(this, binding?.edtxtSearchGit?.text.toString(), 10)
            }
        }
    }

    var viewModel: SearchUserViewModel? = null
    var binding: ActivityAppControlBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppControlBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //menetapkan lifecycle owner untuk livedata
        binding?.lifecycleOwner = this
        supportActionBar?.title = "Search User"

        /*val userRepository = AppControlRepositoryImpl()
        val getAppControlUseCase = GetAppControlUseCase(userRepository)
        val appControlViewModelFactory = AppControlViewModelFactory(getAppControlUseCase)*/

        val userRepository = ListUserRepositoryImpl()
        val getAppControlUseCase = ListUserUseCase(userRepository)
        val appControlViewModelFactory = SearchUserViewModelFactory(getAppControlUseCase)

        //binding = DataBindingUtil.setContentView(this, R.layout.activity_app_control)
        viewModel = ViewModelProvider(this, appControlViewModelFactory)[SearchUserViewModel::class.java]
        binding?.viewModel = viewModel

        //response submit search
        responseApi()
        setOnClickListener()
    }

    fun setOnClickListener(){
        binding?.btnSubmitSearch?.setOnClickListener(this)
    }

    fun responseApi(){
        viewModel?._messageValue?.observe(this, Observer {
            t -> t.let {
                binding?.pbSearchUser?.visibility = View.GONE
                ListUserActivity.launchIntent(this, "%${binding?.edtxtSearchGit?.text.toString()}%", it)
        }
        })
    }
}