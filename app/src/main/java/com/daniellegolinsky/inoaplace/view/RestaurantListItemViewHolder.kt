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
        itemName.text = restaurantInfo.getName()
        itemBorough.text = restaurantInfo.borough

        itemHealthScore.text = restaurantInfo.getLatestGrade()
        when (restaurantInfo.getLatestGrade()) {
            "A" -> itemHealthScore.setTextColor(view.resources.getColor(R.color.aScore, null))
            "B" -> itemHealthScore.setTextColor(view.resources.getColor(R.color.bScore, null))
            else -> itemHealthScore.setTextColor(view.resources.getColor(R.color.cScore, null))
        }
    }
}