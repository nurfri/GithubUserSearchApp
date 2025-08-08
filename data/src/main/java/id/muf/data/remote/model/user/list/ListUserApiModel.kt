package id.muf.data.remote.model.user.list

import com.google.gson.annotations.SerializedName
import id.muf.domain.model.user.list.ListUserItem

data class ListUserApiModel(
    @SerializedName("total_count")
    var totalCount: Int? = null,
    @SerializedName("incomplete_results")
    var incomplete_results: Boolean? = null,
    @SerializedName("items")
    var items: ArrayList<ListUserItemApiModel>? = null
)
