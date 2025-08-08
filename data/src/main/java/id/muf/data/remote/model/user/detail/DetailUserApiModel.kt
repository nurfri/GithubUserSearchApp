package id.muf.data.remote.model.user.detail

import com.google.gson.annotations.SerializedName

data class DetailUserApiModel(
    @SerializedName("login")
    var username: String? = null,
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("avatar_url")
    var avatarUrl: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("company")
    var company: String? = null,
    @SerializedName("blog")
    var blog: String? = null,
    @SerializedName("location")
    var location: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("bio")
    var bio: String? = null,
    @SerializedName("followers")
    var followers: String? = null,
    @SerializedName("following")
    var following: String? = null
)
