package id.muf.domain.repository.user.local

import id.muf.domain.model.user.detail.DetailUser
import id.muf.domain.model.user.list.ListUser
import id.muf.domain.model.user.local.DetailUserLocal
import id.muf.domain.model.user.local.ListUserLocal

interface UserRepository {
    suspend fun insertListUser(user: List<ListUserLocal>)
    suspend fun getListUserByUsername(username: String?): List<ListUserLocal>
    suspend fun deleteListUser(): Boolean
    suspend fun insertDetailUser(user: DetailUserLocal)
    suspend fun getDetailUserByUsername(username: String?): List<DetailUserLocal>
    suspend fun deleteDetailUser(user: DetailUserLocal)
}