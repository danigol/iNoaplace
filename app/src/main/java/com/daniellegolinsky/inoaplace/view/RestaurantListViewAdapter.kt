package com.daniellegolinsky.inoaplace.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daniellegolinsky.inoaplace.R
import com.daniellegolinsky.inoaplace.model.RestaurantInfo

class RestaurantListViewAdapter constructor (private val restaurantInfoList: List<RestaurantInfo>) :
                        RecyclerView.Adapter<RestaurantListItemViewHolder>() {

    override fun getItemCount() = restaurantInfoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                                 .inflate(R.layout.restaurant_item,
                                          parent,
                             false)
        return RestaurantListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantListItemViewHolder, position: Int) {
        holder.bind(restaurantInfoList[position])
    }
}