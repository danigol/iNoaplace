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

    private var _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private var currentPage: Int = 0
    private var maxPages: Int = 1

    private var disposables: CompositeDisposable = CompositeDisposable()

    fun onDestroy() {
        disposables.dispose()
    }

    fun requestRestaurantList(forceUpdateFromServer: Boolean = false) {
        _isLoading.postValue(true)
        disposables.add(
            model.getRestaurantList(forceUpdateFromServer)
                .map { newRestaurantInfo ->
                    if (newRestaurantInfo.isNotEmpty()) {
                        maxPages = newRestaurantInfo.size / itemsPerPage
                        if (newRestaurantInfo.size % itemsPerPage > 0) {
                            ++maxPages
                        }
                        var currentIndex = currentPage * itemsPerPage
                        var lastIndex = newRestaurantInfo.lastIndex
                        if ((currentPage + 1) < maxPages) {
                            lastIndex = (currentPage + 1) * itemsPerPage
                        }
                        _restaurantList.postValue(newRestaurantInfo.subList(
                            currentIndex,
                            lastIndex
                        ))
                        _pageIndicator.postValue("Page: ${currentPage + 1} of $maxPages")
                    }
                }
                .doOnError { Log.e("VIEWMODEL", "Error: ${it?.message}") }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { _isLoading.postValue(false) }
                .subscribe()
        )
    }

    fun nextClicked() {
        if (currentPage < maxPages - 1) {
            ++currentPage
        }
        requestRestaurantList(false)
    }

    fun endClicked() {
        currentPage = maxPages - 1
        requestRestaurantList(false)
    }

    fun backClicked() {
        if (currentPage > 0) {
            --currentPage
        }
        requestRestaurantList(false)
    }

    fun startClicked() {
        currentPage = 0
        requestRestaurantList(false)
    }

}