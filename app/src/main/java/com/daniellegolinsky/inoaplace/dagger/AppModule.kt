package com.daniellegolinsky.inoaplace.dagger

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import com.daniellegolinsky.inoaplace.model.RestaurantsAPI
import com.google.gson.GsonBuilder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Provides
    fun providesRestaurantsAPI(): RestaurantsAPI {
        var gson = GsonBuilder().setLenient().create()
        var retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(RestaurantsAPI::class.java)
    }
}