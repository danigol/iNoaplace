package com.daniellegolinsky.inoaplace.utility

import com.daniellegolinsky.inoaplace.dagger.AppComponent
import com.daniellegolinsky.inoaplace.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class iNoaApplication : DaggerApplication() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent.builder().application(this).build()
        return component
    }
}