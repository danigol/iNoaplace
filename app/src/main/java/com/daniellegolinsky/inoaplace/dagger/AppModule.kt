package com.daniellegolinsky.inoaplace.dagger

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import com.daniellegolinsky.inoaplace.model.RestaurantsAPI

@Module
class AppModule {

    @Provides
    fun providesRestaurantsAPI(): RestaurantsAPI {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .build()
        return retrofit.create(RestaurantsAPI::class.java)
    }
}