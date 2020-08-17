package com.daniellegolinsky.inoaplace.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
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
    lateinit var recyclerViewAdapter: RestaurantListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                                      .get(INoaViewModel::class.java)
        viewModel.restaurantList.observe(this, Observer { updateList(it) })
        viewModel.isLoading.observe(this, Observer { layoutBinding?.invalidateAll() })

        recyclerViewAdapter = RestaurantListViewAdapter()
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
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.requestRestaurantList(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun updateList(restaurantList: List<RestaurantInfo>?) {
        restaurantList?.let {
            recyclerViewAdapter.setRestaurantInfoList(restaurantList)
            layoutBinding.invalidateAll()
        }
    }
}