package com.example.pcs0834.api

import com.example.pcs0834.data.User
import com.example.pcs0834.data.model.DetailUserResponse
import com.example.pcs0834.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET ("search/users")
    @Headers ("Authorization: token  08c16fd1169fe05cbfade1dbff6e99ca9374f0cf")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers ("Authorization: token  08c16fd1169fe05cbfade1dbff6e99ca9374f0cf")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET ("users/{username}/followers")
    @Headers ("Authorization: token  08c16fd1169fe05cbfade1dbff6e99ca9374f0cf")
    fun getFollowers(
        @Path("username") username:String
    ): Call<ArrayList<User>>

    @GET ("users/{username}/following")
    @Headers ("Authorization: token  08c16fd1169fe05cbfade1dbff6e99ca9374f0cf")
    fun getFollowing(
        @Path("username") username:String
    ): Call<ArrayList<User>>
}