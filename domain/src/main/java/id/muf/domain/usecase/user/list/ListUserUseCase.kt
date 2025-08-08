package id.muf.domain.usecase.user.list

import android.content.Context
import id.muf.domain.model.user.list.ListUser
import id.muf.domain.repository.user.list.ListUserRepository

class ListUserUseCase(val listUserRepository: ListUserRepository) {
    suspend fun useCase(context: Context?, username: String, perPage: Int): ListUser {

        return listUserRepository.listUser(context, username, perPage)
    }
}