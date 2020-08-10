package com.daniellegolinsky.inoaplace.dagger

import com.daniellegolinsky.inoaplace.utility.iNoaApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ AndroidSupportInjectionModule::class,
                AppModule::class ]
)
interface AppComponent : AndroidInjector<iNoaApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: iNoaApplication) : Builder
        fun build(): AppComponent
    }
}