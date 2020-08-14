package com.daniellegolinsky.inoaplace.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniellegolinsky.inoaplace.R
import com.daniellegolinsky.inoaplace.model.RestaurantInfo

class RestaurantListItemViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    private var itemName: TextView = view.findViewById(R.id.item_name)
    private var itemHealthScore: TextView = view.findViewById(R.id.item_health_score)
    private var itemBorough: TextView = view.findViewById(R.id.item_borough)

    fun bind(restaurantInfo: RestaurantInfo) {
        itemName.text = restaurantInfo.name
        itemHealthScore.text = restaurantInfo.getLatestGrade()
        itemBorough.text = restaurantInfo.borough
    }
}