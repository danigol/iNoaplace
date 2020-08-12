package com.daniellegolinsky.inoaplace.model

import io.reactivex.Observable
import javax.inject.Inject

class INoaModel @Inject constructor(var restaurantsAPI: RestaurantsAPI) {

    private lateinit var restaurantList: List<RestaurantInfo>

    fun getResturantList(forceUpdate: Boolean = true) : Observable<List<RestaurantInfo>> {
        if (forceUpdate) {
            return restaurantsAPI.getRestaurantList().map {
                restaurantList = it
                return@map it
            }
        }
        return Observable.just(restaurantList)
    }

}