package id.muf.data.repository.user.detail

import android.content.Context
import id.muf.data.Connection
import id.muf.data.mapper.user.detail.DetailUserMapper
import id.muf.domain.model.user.detail.DetailUser
import id.muf.domain.repository.user.detail.DetailUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailUserRepositoryImpl(): DetailUserRepository {
    override suspend fun getDetailUser(context: Context?, username: String): DetailUser = withContext(Dispatchers.IO) {
        val detailUserApiModel = Connection.create(context).getDetailUser(username)
        val detailUserMapper = DetailUserMapper()
        detailUserApiModel.body().let { detailUserMapper.mapApitoDomain(it!!) }
    }
}