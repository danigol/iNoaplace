package com.daniellegolinsky.inoaplace.model

import retrofit2.Call
import retrofit2.http.GET

interface RestaurantsAPI {
    /**
     * Gets the list of restaurants from:
     * https://raw.githubusercontent.com/mongodb/docs-assets/primer-dataset/primer-dataset.json
     */
    @GET("mongodb/docs-assets/primer-dataset/primer-dataset.json")
    fun getRestaurantList() : Call<List<RestaurantInfo>>
}