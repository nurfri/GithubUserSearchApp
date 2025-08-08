package id.muf.data

import id.muf.data.remote.model.user.detail.DetailUserApiModel
import id.muf.data.remote.model.user.list.ListUserApiModel
import retrofit2.Response
import retrofit2.http.*

interface AppApiService {
    @GET("search/users")
    suspend fun listUser(@Query("q") username: String, @Query("per_page") perPage: Int): Response<ListUserApiModel>
    @GET("users/{username}")
    suspend fun getDetailUser(@Path("username") username: String): Response<DetailUserApiModel>
}