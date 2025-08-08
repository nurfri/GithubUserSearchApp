package id.muf.domain.usecase.user.detail

import android.content.Context
import id.muf.domain.model.user.detail.DetailUser
import id.muf.domain.repository.user.detail.DetailUserRepository

class DetailUserUseCase(val detailUserRepository: DetailUserRepository) {
    suspend fun useCase(context: Context?, username: String): DetailUser{

        return detailUserRepository.getDetailUser(context, username)
    }
}