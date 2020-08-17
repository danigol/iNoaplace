package com.daniellegolinsky.inoaplace.dagger

import com.daniellegolinsky.inoaplace.view.INoaActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class INoaActivityModule {

    @ContributesAndroidInjector(
        modules = [
            INoaFragmentModule::class,
            INoaViewModelModule::class
        ]
    )
    abstract fun contributesINoaActivity(): INoaActivity
}