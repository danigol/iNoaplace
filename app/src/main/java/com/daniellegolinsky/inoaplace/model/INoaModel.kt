package com.daniellegolinsky.inoaplace.model

import javax.inject.Inject

class INoaModel @Inject constructor(var restaurantsAPI: RestaurantsAPI) {

    private lateinit var restaurantList: MutableList<RestaurantInfo>

    fun getResturantList() : MutableList<RestaurantInfo> {

        // TODO API request (Should do call to observable method first)


        // TODO Sort by healthscore
        return restaurantList
    }

}