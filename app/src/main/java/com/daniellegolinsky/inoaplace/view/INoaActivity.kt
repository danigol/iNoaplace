package com.daniellegolinsky.inoaplace.view

import android.os.Bundle
import com.daniellegolinsky.inoaplace.R
import dagger.android.support.DaggerAppCompatActivity

class INoaActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inoaplace_activity)

        var fragmentContainer: Int = R.id.restaurant_fragment_container
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer, INoaFragment(), null)
            .commit()
    }
}