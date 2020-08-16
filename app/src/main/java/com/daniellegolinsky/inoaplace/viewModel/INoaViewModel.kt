package com.daniellegolinsky.inoaplace.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniellegolinsky.inoaplace.model.INoaModel
import com.daniellegolinsky.inoaplace.model.RestaurantInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class INoaViewModel @Inject constructor(var model: INoaModel) : ViewModel() {

    private val itemsPerPage = 25

    private var _restaurantList: MutableLiveData<List<RestaurantInfo>> = MutableLiveData()
    val restaurantList: LiveData<List<RestaurantInfo>>
        get() = _restaurantList

    private var _pageIndicator: MutableLiveData<String> = MutableLiveData()
    val pageInidicator: LiveData<String>
        get() = _pageIndicator

    var _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private var currentPage: Int = 0
    private var maxPages: Int = 0

    private var disposables: CompositeDisposable = CompositeDisposable()

    init {
//        requestRestaurantList()
//        if (model.restaurantList.isNotEmpty()) {
//            var remainder: Int = if (model.restaurantList.size % itemsPerPage > 0) {
//                1
//            }
//            else {
//                0
//            }
//            maxPages = ( model.restaurantList.size / itemsPerPage ) + remainder
//        }
    }

    fun onDestroy() {
        disposables.dispose()
    }

    fun requestRestaurantList() {
        disposables.add(
            model.getResturantList().map { newRestaurantInfo ->
                _isLoading.postValue(true)
                displayPage(newRestaurantInfo)
            }.onErrorReturn {
                Log.e("VIEW_MODEL", it.message ?: "-No error string-")
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { _isLoading.postValue(false) }
        )
    }

    // Take a chunk out of the data to paginate
    fun displayPage(newRestaurantList: List<RestaurantInfo>) {
        if (newRestaurantList.isNotEmpty()) {
            if (currentPage < maxPages) {
                var lastIndex = (currentPage + 1) * itemsPerPage
                if (lastIndex > newRestaurantList.size) {
                    lastIndex = newRestaurantList.lastIndex + 1 // Sublist is exclusive
                }
                _restaurantList.postValue(newRestaurantList.subList(
                    currentPage * itemsPerPage,
                    lastIndex
                ))
            } else if (currentPage == maxPages) {
                _restaurantList.postValue(newRestaurantList.subList(
                    currentPage * itemsPerPage,
                    newRestaurantList.lastIndex
                ))
            }
            _pageIndicator.postValue("Page: ${currentPage + 1} of $maxPages")
        }
    }

    fun nextClicked() {
        if (currentPage < maxPages - 1) {
            ++currentPage
        }
        displayPage(model.restaurantList)
    }

    fun endClicked() {
        currentPage = maxPages - 1
        displayPage(model.restaurantList)
    }

    fun backClicked() {
        if (currentPage > 0) {
            --currentPage
        }
        displayPage(model.restaurantList)
    }

    fun startClicked() {
        currentPage = 0
        displayPage(model.restaurantList)
    }

}