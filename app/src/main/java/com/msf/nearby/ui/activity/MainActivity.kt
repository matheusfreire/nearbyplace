package com.msf.nearby.ui.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.msf.nearby.R
import com.msf.nearby.vm.PlacesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var placesViewModel: PlacesViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_cafe, R.id.navigation_bars, R.id.navigation_restaurants
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        placesViewModel = ViewModelProvider(this).get(PlacesViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener { _, _, _ ->
            placesViewModel.updateActualFragment(
                navController.currentDestination?.id
            )
        }
    }

    override fun onRestart() {
        super.onRestart()
        navController.navigate(placesViewModel.lastFragmentId)
    }
}