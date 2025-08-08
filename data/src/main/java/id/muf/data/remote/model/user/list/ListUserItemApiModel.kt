package id.muf.data.remote.model.user.list

import com.google.gson.annotations.SerializedName

data class ListUserItemApiModel(
    @SerializedName("login")
    var username: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("avatar_url")
    var avatarUrl: String? = null
)
