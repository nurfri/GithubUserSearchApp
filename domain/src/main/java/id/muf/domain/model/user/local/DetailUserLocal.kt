package id.muf.domain.model.user.local

data class DetailUserLocal(
    var id: Int? = null,
    var username: String? = null,
    var idUser: String? = null,
    var avatarUrl: String? = null,
    var name: String? = null,
    var company: String? = null,
    var blog: String? = null,
    var location: String? = null,
    var email: String? = null,
    var bio: String? = null,
    var followers: String? = null,
    var following: String? = null
)