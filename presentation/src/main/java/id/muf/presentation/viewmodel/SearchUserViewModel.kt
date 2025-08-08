package id.muf.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.muf.domain.model.user.list.ListUserItem
import id.muf.domain.usecase.user.list.ListUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchUserViewModel(var listUserUseCase: ListUserUseCase): ViewModel() {

    var messageValue = MutableLiveData<ArrayList<ListUserItem>>()
    var _messageValue: LiveData<ArrayList<ListUserItem>> = messageValue

    fun fetchAppControl(context: Context?, username: String, perPage: Int){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                try{
                    val listUser = listUserUseCase.useCase(context, username, perPage)
                    messageValue.value = listUser.items as ArrayList<ListUserItem>?
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