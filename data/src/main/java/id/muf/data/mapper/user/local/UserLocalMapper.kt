package id.muf.data.mapper.user.local

import id.muf.data.local.user.entity.DetailUserEntity
import id.muf.data.local.user.entity.ListUserEntity
import id.muf.domain.model.user.list.ListUserItem
import id.muf.domain.model.user.local.DetailUserLocal
import id.muf.domain.model.user.local.ListUserLocal

fun ListUserEntity.toDomain() = ListUserLocal(id, username, idUser, avatarUrl)
fun ListUserLocal.toEntity() = id?.let { ListUserEntity(it, username, idUser, avatarUrl) }

fun DetailUserEntity.toDomain() = DetailUserLocal(id, username, idUser, avatarUrl, name, company, blog, location, email, bio, followers, following)
fun DetailUserLocal.toEntity() = id?.let { DetailUserEntity(it, username, idUser, avatarUrl, name, company, blog, location, email, bio, followers, following) }

fun ListUserItem.toDomain() = ListUserLocal(0, username, id.toString(), avatarUrl)