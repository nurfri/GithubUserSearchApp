package id.muf.data.repository.user.local

import id.muf.data.local.user.dao.UserDao
import id.muf.data.local.user.entity.ListUserEntity
import id.muf.data.mapper.user.local.toDomain
import id.muf.data.mapper.user.local.toEntity
import id.muf.domain.model.user.local.DetailUserLocal
import id.muf.domain.model.user.local.ListUserLocal
import id.muf.domain.repository.user.local.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(private val userDao: UserDao): UserRepository {
    override suspend fun insertListUser(user: List<ListUserLocal>) = withContext(Dispatchers.IO) {
        val userEntities = user.map { it.toEntity() }
        userDao.insertListUser(userEntities as List<ListUserEntity>)
    }

    override suspend fun getListUserByUsername(username: String?): List<ListUserLocal>  = withContext(Dispatchers.IO) {
        userDao.getListUserByUsername(username).map { it.toDomain() }
    }

    override suspend fun deleteListUser(): Boolean = withContext(Dispatchers.IO) {
        val delete = userDao.deleteListUser()
        return@withContext delete > 0
    }

    override suspend fun insertDetailUser(user: DetailUserLocal) = withContext(Dispatchers.IO) {
        userDao.insertDetailUser(user.toEntity()!!)
        //return@withContext rowId > -1
    }

    override suspend fun getDetailUserByUsername(username: String?): List<DetailUserLocal> = withContext(Dispatchers.IO) {
        userDao.getDetailUserByUsername(username).map { it.toDomain() }
    }

    override suspend fun deleteDetailUser(user: DetailUserLocal) = withContext(Dispatchers.IO) {
        userDao.deleteDetailUser(user.toEntity()!!)
    }
}