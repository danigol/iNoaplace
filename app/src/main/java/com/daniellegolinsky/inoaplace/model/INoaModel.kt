package com.daniellegolinsky.inoaplace.model

import android.util.Log
import io.reactivex.Observable
import javax.inject.Inject

class INoaModel @Inject constructor(var restaurantsAPI: RestaurantsAPI) {

    var restaurantList: List<RestaurantInfo> = listOf()

    // TODO Obviously remove mock data
//    init {
//        var itemList: MutableList<RestaurantInfo> = mutableListOf()
//        for (i in 0..42) {
//            var item = RestaurantInfo()
//            item.name = "Restaurant $i"
//            item.borough = "Brooklyn"
//            item.grades = when {
//                i % 3 == 0 -> {
//                    "A"
//                }
//                i % 3 == 1 -> {
//                    "B"
//                }
//                else -> {
//                    "C"
//                }
//            }
//            itemList.add(item)
//        }
//        restaurantList = itemList
//    }

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