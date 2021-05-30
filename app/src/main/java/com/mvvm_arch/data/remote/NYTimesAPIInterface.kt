package com.mvvm_arch.data.remote

import com.mvvm_arch.data.model.APIResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesAPIInterface {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/30.json")
    fun getMostViewedNews(@Query("api-key") apiKey: String): Call<APIResponse>

    companion object {

        private const val BASE_URL = "https://api.nytimes.com/"

        fun create(): NYTimesAPIInterface {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NYTimesAPIInterface::class.java)
        }
    }
}