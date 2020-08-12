package com.daniellegolinsky.inoaplace.view

import android.os.Bundle
import com.daniellegolinsky.inoaplace.R
import dagger.android.DaggerActivity

class INoaActivity : DaggerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inoaplace_activity)
    }
}