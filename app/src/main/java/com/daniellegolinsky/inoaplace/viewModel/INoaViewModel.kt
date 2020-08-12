package com.daniellegolinsky.inoaplace.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniellegolinsky.inoaplace.model.INoaModel
import com.daniellegolinsky.inoaplace.model.RestaurantInfo
import javax.inject.Inject

class INoaViewModel @Inject constructor(var model: INoaModel) : ViewModel() {

    private var _restaurantList: MutableLiveData<List<RestaurantInfo>> = MutableLiveData()
    val restaurantList: LiveData<List<RestaurantInfo>>
        get() = _restaurantList
}