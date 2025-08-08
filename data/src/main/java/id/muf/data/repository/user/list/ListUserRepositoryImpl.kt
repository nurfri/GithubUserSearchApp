package id.muf.data.repository.user.list

import android.content.Context
import id.muf.data.Connection
import id.muf.data.mapper.user.list.ListUserMapper
import id.muf.domain.model.user.list.ListUser
import id.muf.domain.repository.user.list.ListUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListUserRepositoryImpl(): ListUserRepository {
    override suspend fun listUser(context: Context?, username: String, perPage: Int): ListUser = withContext(Dispatchers.IO) {
        val listUserApiModel = Connection.create(context).listUser(username, perPage)
        println("TES#:${listUserApiModel.body()?.items?.get(0)?.id}")
        val listUserMapper = ListUserMapper()
        listUserApiModel.body().let { listUserMapper.mapApitoDomain(it!!) }
    }
}