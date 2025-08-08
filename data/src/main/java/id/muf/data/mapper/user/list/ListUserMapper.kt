package id.muf.data.mapper.user.list

import id.muf.data.remote.model.user.list.ListUserApiModel
import id.muf.data.remote.model.user.list.ListUserItemApiModel
import id.muf.domain.model.user.list.ListUser
import id.muf.domain.model.user.list.ListUserItem

class ListUserMapper {
    fun mapApitoDomain(listUserApiModel: ListUserApiModel): ListUser {
        /*val listUserItem = ArrayList<ListUserItem>()
        listUserApiModel.items?.map { listUserItem }*/

        return ListUser(
            totalCount = listUserApiModel.totalCount,
            incompleteResults = listUserApiModel.incomplete_results,
            items = mapApitoDomainItem(listUserApiModel)
        )
    }

    fun mapApitoDomainItem(listUserApiModel: ListUserApiModel): List<ListUserItem>? {
        return listUserApiModel.items?.map { mapApitoDomainItemList(it) }
    }

    fun mapApitoDomainItemList(listUserItemApiModel: ListUserItemApiModel): ListUserItem {
        return ListUserItem(
            username = listUserItemApiModel.username,
            id = listUserItemApiModel.id,
            avatarUrl = listUserItemApiModel.avatarUrl
        )
    }




}