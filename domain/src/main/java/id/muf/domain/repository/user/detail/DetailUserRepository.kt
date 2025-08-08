package id.muf.domain.repository.user.detail

import android.content.Context
import id.muf.domain.model.user.detail.DetailUser

interface DetailUserRepository {
    suspend fun getDetailUser(context: Context?, username: String): DetailUser
}