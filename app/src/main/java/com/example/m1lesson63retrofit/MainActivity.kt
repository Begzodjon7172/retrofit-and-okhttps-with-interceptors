package com.example.m1lesson63retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.m1lesson63retrofit.models.MarvelData
import com.example.m1lesson63retrofit.models.create.ReqUserCreator
import com.example.m1lesson63retrofit.models.create.ResUserCreator
import com.example.m1lesson63retrofit.models.create.ResUserUpdated
import com.example.m1lesson63retrofit.models.reqres.UserData
import com.example.m1lesson63retrofit.models.single_user.SingleUser
import com.example.m1lesson63retrofit.networking.ApiClient
import com.example.m1lesson63retrofit.networking.ApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.io.IOException

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*

        // retrofit
        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)

        apiService.getMarvels()
            .enqueue(object : Callback<List<MarvelData>> {
                override fun onResponse(
                    call: Call<List<MarvelData>>,
                    response: Response<List<MarvelData>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.d(TAG, "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<List<MarvelData>>, t: Throwable) {

                }
            })


         */

        /*
        // okhttp
        val okHttpClient = OkHttpClient()
        val request = Request.Builder().url("https:://jsonplaceholder.typicode.com/users/1").build()
        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {

            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    Log.d(TAG, "onResponse: ${response.body?.string()}")
                }
            }
        })


         */

        /*

        // page orqali saralab olish
        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
        apiService.getUser(1).enqueue(object:Callback<UserData>{
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {

            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {

            }

        })


         */


        /*
        // get single user by id
        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
        apiService.getSingleUser(23).enqueue(object:Callback<SingleUser>{
            override fun onResponse(call: Call<SingleUser>, response: Response<SingleUser>) {
                if (response.isSuccessful){
                    Log.d(TAG, "onResponse: Success")
                }else if(response.code() in 400..499){
                    Log.d(TAG, "onResponse: Client not found")
                }
            }

            override fun onFailure(call: Call<SingleUser>, t: Throwable) {

            }

        })


         */

        /*

        // bitta obyekt yaratish post methodi orqali
        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
        apiService.createUser(ReqUserCreator("Programmist", "Begzodjon")).enqueue(object:Callback<ResUserCreator>{
            override fun onResponse(
                call: Call<ResUserCreator>,
                response: Response<ResUserCreator>
            ) {

            }

            override fun onFailure(call: Call<ResUserCreator>, t: Throwable) {

            }
        })


         */

        /*

        //update user by id
        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
        apiService.updateUser(1, ReqUserCreator("Programmist", "Begzodjon")).enqueue(object:Callback<ResUserUpdated>{
            override fun onResponse(
                call: Call<ResUserUpdated>,
                response: Response<ResUserUpdated>
            ) {

            }

            override fun onFailure(call: Call<ResUserUpdated>, t: Throwable) {

            }

        })


         */

        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
       val a = apiService.getSingleUser(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
           .subscribe{
               Log.d(TAG, "onCreate: $it")
           }

    }
}