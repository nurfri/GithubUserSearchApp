package id.muf.data.mapper.user.detail

import id.muf.data.remote.model.user.detail.DetailUserApiModel
import id.muf.data.remote.model.user.list.ListUserApiModel
import id.muf.domain.model.user.detail.DetailUser
import id.muf.domain.model.user.list.ListUser
import id.muf.domain.model.user.list.ListUserItem

class DetailUserMapper {
    fun mapApitoDomain(detailUserApiModel: DetailUserApiModel): DetailUser {

        return DetailUser(
            username = detailUserApiModel.username,
            id = detailUserApiModel.id,
            avatarUrl = detailUserApiModel.avatarUrl,
            name = detailUserApiModel.name,
            company = detailUserApiModel.company,
            blog = detailUserApiModel.blog,
            location = detailUserApiModel.location,
            email = detailUserApiModel.email,
            bio = detailUserApiModel.bio,
            followers = detailUserApiModel.followers,
            following = detailUserApiModel.following,
        )
    }
}