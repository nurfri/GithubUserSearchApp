package id.muf.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.muf.domain.usecase.user.detail.DetailUserUseCase

class DetailUserViewModelFactory(var detailUserUseCase: DetailUserUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailUserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailUserViewModel(detailUserUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}