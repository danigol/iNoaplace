package com.daniellegolinsky.inoaplace.dagger

import com.daniellegolinsky.inoaplace.model.RestaurantsAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class AppModule {

    @Provides
    fun providesRestaurantsAPI(): RestaurantsAPI {
//        var baseUrl = "https://raw.githubusercontent.com/"
        var baseUrl = "https://gist.githubusercontent.com/"
        var gson = GsonBuilder().setLenient().create()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
        return retrofit.create(RestaurantsAPI::class.java)
    }
}