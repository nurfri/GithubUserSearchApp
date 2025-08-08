package id.muf.data.local.user.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_list_user")
data class ListUserEntity(
    @ColumnInfo("id")
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo("username")
    var username: String? = null,
    @ColumnInfo("id_user")
    var idUser: String? = null,
    @ColumnInfo("avatar_url")
    var avatarUrl: String? = null
)