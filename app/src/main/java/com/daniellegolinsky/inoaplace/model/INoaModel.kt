package com.daniellegolinsky.inoaplace.model

import android.util.Log
import io.reactivex.Observable
import javax.inject.Inject

class INoaModel @Inject constructor(var restaurantsAPI: RestaurantsAPI) {

    var restaurantList: List<RestaurantInfo> = listOf()

    fun getResturantList(forceUpdate: Boolean = true) : Observable<List<RestaurantInfo>> {
        if (forceUpdate) {
            return restaurantsAPI.getRestaurantList().map {
                restaurantList = it
                return@map it
            }.onErrorReturn {
                Log.e("MODEL", it.message ?: "-No error string-")
                return@onErrorReturn restaurantList
            }
        }
        return Observable.just(restaurantList)
    }

}