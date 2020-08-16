package com.daniellegolinsky.inoaplace.model

import io.reactivex.Observable
import retrofit2.http.GET

interface RestaurantsAPI {
    /**
     * Gets the list of restaurants from:
     * https://raw.githubusercontent.com/mongodb/docs-assets/primer-dataset/primer-dataset.json
     * mongodb/docs-assets/primer-dataset/primer-dataset.json
     * gist: danigol/e3204914a9bebd81458cfcea69cf05ef/raw/6182d12c88d6ae87d08723798d97b9c489552f44/testJson.json
     * gist: danigol/ff71caf344140d8ab9617ba9d03b17a0/raw/70fd209e36319cd42005801cb49be8cb478dd50f/testJson2.json
     */
    @GET("danigol/ff71caf344140d8ab9617ba9d03b17a0/raw/70fd209e36319cd42005801cb49be8cb478dd50f/testJson2.json")
    fun getRestaurantList(): Observable<List<RestaurantInfo>>
}