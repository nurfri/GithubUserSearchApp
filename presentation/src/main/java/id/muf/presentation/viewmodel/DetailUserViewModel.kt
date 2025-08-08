package id.muf.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.muf.domain.model.user.detail.DetailUser
import id.muf.domain.usecase.user.detail.DetailUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailUserViewModel(var detailUserUseCase: DetailUserUseCase): ViewModel() {

    var messageValue = MutableLiveData<DetailUser>()
    var _messageValue: LiveData<DetailUser> = messageValue

    fun fetchDetailUser(context: Context?, username: String){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                try{
                    val detailUser = detailUserUseCase.useCase(context, username)
                    messageValue.value = detailUser
                }catch(e: Exception){
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}