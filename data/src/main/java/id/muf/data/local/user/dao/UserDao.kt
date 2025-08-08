package id.muf.data.local.user.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.muf.data.local.user.entity.DetailUserEntity
import id.muf.data.local.user.entity.ListUserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListUser(user: List<ListUserEntity>)

    @Query("select * from tb_list_user where username like :username")
    suspend fun getListUserByUsername(username: String?): List<ListUserEntity>

    @Query("delete from tb_list_user")
    suspend fun deleteListUser(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailUser(user: DetailUserEntity)

    @Query("select * from tb_detail_user where username = :username")
    suspend fun getDetailUserByUsername(username: String?): List<DetailUserEntity>

    @Delete
    suspend fun deleteDetailUser(user: DetailUserEntity)
}