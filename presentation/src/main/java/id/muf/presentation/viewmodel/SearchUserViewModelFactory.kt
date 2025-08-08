package id.muf.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.muf.domain.usecase.user.list.ListUserUseCase

class SearchUserViewModelFactory(var listUserUseCase: ListUserUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchUserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchUserViewModel(listUserUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}