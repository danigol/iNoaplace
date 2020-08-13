package com.daniellegolinsky.inoaplace.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.daniellegolinsky.inoaplace.R
import com.daniellegolinsky.inoaplace.dagger.ViewModelProviderFactory
import com.daniellegolinsky.inoaplace.databinding.InoaplaceFragmentBinding
import com.daniellegolinsky.inoaplace.model.RestaurantInfo
import com.daniellegolinsky.inoaplace.viewModel.INoaViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class INoaFragment @Inject constructor() : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    lateinit var viewModel: INoaViewModel

    lateinit var layoutBinding: InoaplaceFragmentBinding

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                                      .get(INoaViewModel::class.java)

        viewModel.restaurantList.observe(this, Observer { updateList(it) })
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        layoutBinding = DataBindingUtil.inflate(inflater,
                                                R.layout.inoaplace_fragment,
                                                container,
                                 false)
        layoutBinding.lifecycleOwner = this
        layoutBinding.viewModel = viewModel
        layoutBinding.executePendingBindings()

        return layoutBinding.root
    }

    override fun onResume() {
        super.onResume()
        recyclerView = layoutBinding.root.findViewById(R.id.restaurant_list_recyclerview)
        viewModel.createMockData()
    }

    private fun updateList(restaurantList: List<RestaurantInfo>?) {
        restaurantList?.let {
            recyclerView.adapter = RestaurantListViewAdapter(restaurantList)
        }
    }
}