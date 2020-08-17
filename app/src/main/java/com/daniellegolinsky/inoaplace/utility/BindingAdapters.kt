package com.daniellegolinsky.inoaplace.utility

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleIfEmpty")
fun showIfEmpty(view: View, isEmpty: Boolean?) {
    when(isEmpty) {
        true -> view.visibility = View.VISIBLE
        else -> view.visibility = View.GONE
    }
}

@BindingAdapter("loadingVisibility")
fun showIfLoading(view: View, isLoading: Boolean?) {
    when (isLoading) {
        true -> view.visibility = View.VISIBLE
        else -> view.visibility = View.GONE
    }
}