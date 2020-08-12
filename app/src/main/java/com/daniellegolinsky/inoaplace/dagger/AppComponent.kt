package com.daniellegolinsky.inoaplace.dagger

import com.daniellegolinsky.inoaplace.utility.INoaApplication
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
interface AppComponent : AndroidInjector<INoaApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: INoaApplication) : Builder
        fun build(): AppComponent
    }
}