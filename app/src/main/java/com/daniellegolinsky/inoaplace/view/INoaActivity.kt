package com.daniellegolinsky.inoaplace.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.daniellegolinsky.inoaplace.R
import com.daniellegolinsky.inoaplace.dagger.ViewModelProviderFactory
import com.daniellegolinsky.inoaplace.viewModel.INoaViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class INoaActivity @Inject constructor() : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    lateinit var viewModel: INoaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inoaplace_activity)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                                        .get(INoaViewModel::class.java)

        var fragmentContainer: Int = R.id.restaurant_fragment_container
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer, INoaFragment(), null)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.refresh_menu_button -> {
                viewModel.requestRestaurantList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}