package id.muf.presentation.ui.user.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import id.muf.data.repository.image.GlideImageLoader
import id.muf.data.repository.user.detail.DetailUserRepositoryImpl
import id.muf.domain.model.user.detail.DetailUser
import id.muf.domain.repository.Image.ImageLoader
import id.muf.domain.usecase.user.detail.DetailUserUseCase
import id.muf.presentation.databinding.ActivityDetailUserBinding
import id.muf.presentation.viewmodel.DetailUserViewModel
import id.muf.presentation.viewmodel.DetailUserViewModelFactory
import kotlinx.coroutines.launch

class DetailUserActivity: AppCompatActivity() {

    companion object{
        var mUsername: String? = null
        fun launchIntent(caller: Activity?, username: String?){
            val intent = Intent(caller, DetailUserActivity::class.java)
            caller?.startActivity(intent)
            mUsername = username
        }
    }

    var binding: ActivityDetailUserBinding? = null
    var viewModel: DetailUserViewModel? = null
    var imageLoader: GlideImageLoader? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.lifecycleOwner = this
        imageLoader = GlideImageLoader()

        val detailUserRepository = DetailUserRepositoryImpl()
        val detailUserUseCase = DetailUserUseCase(detailUserRepository)
        val detailUserViewModelFactory = DetailUserViewModelFactory(detailUserUseCase)

        viewModel = ViewModelProvider(this, detailUserViewModelFactory)[DetailUserViewModel::class.java]

        supportActionBar?.title = "Detail User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //fetch api
        viewModel?.fetchDetailUser(this, mUsername.toString())
        //response api
        responseApi()
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

    fun responseApi(){
        viewModel?._messageValue?.observe(this, Observer {
                t -> t.let {
            dismissShimmer()
            setUIDetailUser(it)
        }
        })
    }

    fun setUIDetailUser(detailUser: DetailUser){
        binding?.txtDetailUsername?.text = detailUser.username ?: "Empty"
        binding?.txtDetailName?.text = detailUser.name ?: "Empty"
        binding?.txtDetailCompany?.text = detailUser.company ?: "Empty"
        binding?.txtDetailBlog?.text = detailUser.blog ?: "Empty"
        binding?.txtDetailLocation?.text = detailUser.location ?: "Empty"
        binding?.txtDetailEmail?.text = detailUser.email ?: "Empty"
        binding?.txtDetailBio?.text = detailUser.bio ?: "Empty"
        binding?.txtDetailFollowers?.text = detailUser.followers ?: "Empty"
        binding?.txtDetailFollowing?.text = detailUser.following ?: "Empty"
        lifecycleScope.launch {
            imageLoader?.loadImage(detailUser.avatarUrl.toString(), binding?.ivDetailUser!!)
        }
    }

    fun dismissShimmer(){
        if(binding?.ivDetailUserShimmer?.visibility == View.VISIBLE){
            binding?.ivDetailUserShimmer?.visibility = View.INVISIBLE
            binding?.ivDetailUser?.visibility = View.VISIBLE

            binding?.cvDetailUserShimmer?.visibility = View.INVISIBLE
            binding?.cvDetailUser?.visibility = View.VISIBLE
        }
    }
}