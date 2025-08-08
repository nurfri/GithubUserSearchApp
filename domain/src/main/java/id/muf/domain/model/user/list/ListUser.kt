package id.muf.domain.model.user.list

data class ListUser(
    var totalCount: Int? = null,
    var incompleteResults: Boolean? = null,
    var items: List<ListUserItem>? = null
)
