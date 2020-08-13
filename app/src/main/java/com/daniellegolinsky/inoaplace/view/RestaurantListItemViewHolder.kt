package com.daniellegolinsky.inoaplace.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniellegolinsky.inoaplace.R
import com.daniellegolinsky.inoaplace.model.RestaurantInfo

class RestaurantListItemViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    fun bind(restaurantInfo: RestaurantInfo) {
        var itemName = view.findViewById<TextView>(R.id.item_name)
        var itemHealthScore = view.findViewById<TextView>(R.id.item_health_score)
        var itemBorough = view.findViewById<TextView>(R.id.item_borough)

        itemName.text = restaurantInfo.name
        itemHealthScore.text = restaurantInfo.getLatestGrade()
        itemBorough.text = restaurantInfo.borough
    }
}