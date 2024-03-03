package com.example.m1lesson63retrofit.networking

import com.example.m1lesson63retrofit.models.create.ReqUserCreator
import com.example.m1lesson63retrofit.models.create.ResUserCreator
import com.example.m1lesson63retrofit.models.create.ResUserUpdated
import com.example.m1lesson63retrofit.models.reqres.UserData
import com.example.m1lesson63retrofit.models.single_user.SingleUser
import io.reactivex.rxjava3.core.Observable
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
//
//    @GET("demos/marvel/")
//    fun getMarvels(): Call<List<MarvelData>>


    @GET("api/users")
    fun getUser(@Query("page") page: Int): Call<UserData>

    @GET("api/users/{id}")
    fun getSingleUser(@Path("id") id: Int): Observable<SingleUser>

    @POST("api/users")
    fun createUser(@Body reqUserCreator: ReqUserCreator): Call<ResUserCreator>

    @PUT("api/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body reqUserCreator: ReqUserCreator): Call<ResUserUpdated>

    @PATCH("api/users/{id}")
    fun updateUser2(@Path("id") id: Int, @Body reqUserCreator: ReqUserCreator): Call<ResUserUpdated>

    @DELETE("api/users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<RequestBody>

}