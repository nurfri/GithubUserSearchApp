package id.muf.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.muf.data.mapper.user.local.toDomain
import id.muf.domain.model.user.list.ListUserItem
import id.muf.domain.model.user.local.ListUserLocal
import id.muf.domain.repository.user.local.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListUserViewModel(var userRepository: UserRepository): ViewModel() {

    var messageValue = MutableLiveData<ArrayList<ListUserLocal>>()
    var _messageValue: LiveData<ArrayList<ListUserLocal>> = messageValue
    fun saveListUser(username: String?, listUserItem: ArrayList<ListUserItem>){
        viewModelScope.launch {
            progressDB(username, listUserItem)
        }
    }

    suspend fun progressDB(username: String?, listUserItem: ArrayList<ListUserItem>){
        userRepository.deleteListUser()
        delay(1000)
        userRepository.insertListUser(listUserItem.map { it.toDomain() })
        delay(1000)
        val valueListUser = userRepository.getListUserByUsername(username)
        messageValue.value = valueListUser as ArrayList<ListUserLocal>
    }

    override fun onCleared() {
        super.onCleared()

    }

}