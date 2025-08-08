package id.muf.domain.repository.user.list

import android.content.Context
import id.muf.domain.model.user.list.ListUser

interface ListUserRepository {
    suspend fun listUser(context: Context?, username: String, perPage: Int): ListUser
}