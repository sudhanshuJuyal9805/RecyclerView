package com.example.recycleradapter.api

import com.example.recycleradapter.model.User
import retrofit2.Response
import retrofit2.http.GET

interface apiHelper
{
    @GET("/posts")
    suspend fun getUsers(): Response<User>
}