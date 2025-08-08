package id.muf.data.local.user.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_detail_user")
data class DetailUserEntity(
    @ColumnInfo("id")
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo("username")
    var username: String? = null,
    @ColumnInfo("id_user")
    var idUser: String? = null,
    @ColumnInfo("avatar_url")
    var avatarUrl: String? = null,
    @ColumnInfo("name")
    var name: String? = null,
    @ColumnInfo("company")
    var company: String? = null,
    @ColumnInfo("blog")
    var blog: String? = null,
    @ColumnInfo("location")
    var location: String? = null,
    @ColumnInfo("email")
    var email: String? = null,
    @ColumnInfo("bio")
    var bio: String? = null,
    @ColumnInfo("followers")
    var followers: String? = null,
    @ColumnInfo("following")
    var following: String? = null
)