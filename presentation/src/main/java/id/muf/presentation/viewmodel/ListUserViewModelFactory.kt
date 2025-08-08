package id.muf.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.muf.domain.repository.user.local.UserRepository

class ListUserViewModelFactory(var userRepository: UserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListUserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListUserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}