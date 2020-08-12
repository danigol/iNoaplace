package com.daniellegolinsky.inoaplace.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.daniellegolinsky.inoaplace.R
import com.daniellegolinsky.inoaplace.dagger.ViewModelProviderFactory
import com.daniellegolinsky.inoaplace.databinding.InoaplaceFragmentBinding
import com.daniellegolinsky.inoaplace.viewModel.INoaViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class INoaFragment @Inject constructor() : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    lateinit var viewModel: INoaViewModel

    lateinit var layoutBinding: InoaplaceFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                                      .get(INoaViewModel::class.java)
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
}