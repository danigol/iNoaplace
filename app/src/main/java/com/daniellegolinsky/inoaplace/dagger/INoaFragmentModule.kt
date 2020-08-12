package com.daniellegolinsky.inoaplace.dagger

import com.daniellegolinsky.inoaplace.view.INoaFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class INoaFragmentModule {

    @ContributesAndroidInjector(
        modules = [
            INoaViewModelModule::class
        ]
    )
    abstract fun contributesINoaFragment(): INoaFragment
}