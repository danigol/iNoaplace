package com.daniellegolinsky.inoaplace.dagger

import androidx.lifecycle.ViewModel
import com.daniellegolinsky.inoaplace.viewModel.INoaViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class INoaViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(INoaViewModel::class)
    abstract fun bindsINoaViewModel(iNoaViewModel: INoaViewModel): ViewModel
}