package id.muf.domain.model.user.detail

data class DetailUser(
    var username: String? = null,
    var id: String? = null,
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
