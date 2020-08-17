package com.daniellegolinsky.inoaplace.model

import android.util.Log
import io.reactivex.Observable
import javax.inject.Inject

class INoaModel @Inject constructor(var restaurantsAPI: RestaurantsAPI) {

    var cachedRestaurantList: List<RestaurantInfo> = listOf()

    fun getRestaurantList(forceUpdate: Boolean) : Observable<List<RestaurantInfo>> {
        if (cachedRestaurantList.isEmpty() || forceUpdate) {
            return restaurantsAPI.getRestaurantList().map {
                cachedRestaurantList = it
                return@map it
            }.onErrorReturn {
                Log.e("MODEL", it.message ?: "-No error string-")
                return@onErrorReturn listOf<RestaurantInfo>()
            }
        }
        return Observable.just(cachedRestaurantList)
    }
}
