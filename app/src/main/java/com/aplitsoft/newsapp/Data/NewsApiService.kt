package com.aplitsoft.newsapp.Data

import com.aplitsoft.newsapp.Data.Response.News
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.zip.Deflater

const val KEY = "51a31a68f9454bd3a82bbc6b70acc07b"

//http://newsapi.org/v2/top-headlines?country=us&apiKey=51a31a68f9454bd3a82bbc6b70acc07b

interface NewsApiService {

    @GET("top-headlines")
    fun getLastNewsAsync(
        @Query("country") country: String = "us"
    ): Deferred<News>

    companion object {
        operator fun invoke(): NewsApiService {
            val requestInterceptor = Interceptor {
                val url = it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("apiKey", KEY)
                    .build()

                val request = it.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor it.proceed(request)
            }
            val okHttpClient: OkHttpClient =
                OkHttpClient.Builder().addInterceptor(requestInterceptor).build()

            return  Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://newsapi.org/v2/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsApiService::class.java)

        }
    }

}