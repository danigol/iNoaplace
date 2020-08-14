package com.daniellegolinsky.inoaplace.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniellegolinsky.inoaplace.model.INoaModel
import com.daniellegolinsky.inoaplace.model.RestaurantInfo
import javax.inject.Inject

class INoaViewModel @Inject constructor(var model: INoaModel) : ViewModel() {

    private val itemsPerPage = 25

    private var _restaurantList: MutableLiveData<List<RestaurantInfo>> = MutableLiveData()
    val restaurantList: LiveData<List<RestaurantInfo>>
        get() = _restaurantList

    private var _pageIndicator: MutableLiveData<String> = MutableLiveData()
    val pageInidicator: LiveData<String>
        get() = _pageIndicator

    private var currentPage: Int = 0
    private var maxPages: Int = 0

    init {
        if (model.restaurantList.isNotEmpty()) {
            var remainder: Int = if (model.restaurantList.size % itemsPerPage > 0) {
                1
            }
            else {
                0
            }
            maxPages = ( model.restaurantList.size / itemsPerPage ) + remainder
        }
    }

    // Take a chunk out of the data to paginate
    fun displayPage() {
        if (currentPage < maxPages) {
            var lastIndex = (currentPage + 1) * itemsPerPage
            if (lastIndex > model.restaurantList.size) {
                lastIndex = model.restaurantList.lastIndex
            }
            _restaurantList.value = model.restaurantList.subList(currentPage * itemsPerPage,
                                                                 lastIndex)
        }
        else if (currentPage == maxPages) {
            _restaurantList.value = model.restaurantList.subList(currentPage * itemsPerPage,
                                                                 model.restaurantList.lastIndex)
        }
        _pageIndicator.value = "Page: ${currentPage + 1} of $maxPages"
    }

    fun nextClicked() {
        if (currentPage < maxPages - 1) {
            ++currentPage
        }
        displayPage()
    }

    fun endClicked() {
        currentPage = maxPages - 1
        displayPage()
    }

    fun backClicked() {
        if (currentPage > 0) {
            --currentPage
        }
        displayPage()
    }

    fun startClicked() {
        currentPage = 0
        displayPage()
    }

}