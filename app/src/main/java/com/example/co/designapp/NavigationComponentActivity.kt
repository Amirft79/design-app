package com.example.co.designapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.co.designapp.databinding.ActivityNavigationComponentBinding

class NavigationComponentActivity : AppCompatActivity() {

    lateinit var binding:ActivityNavigationComponentBinding
    lateinit var navController:NavController
    lateinit var drawerlayout:DrawerLayout
    lateinit var appbarconfiguration:AppBarConfiguration
    lateinit var navhost:NavHostFragment
    lateinit var listener:NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNavigationComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.navigteToollbar)
        navhost=supportFragmentManager.findFragmentById(R.id.fragment_container_view)
                as NavHostFragment
        navController=navhost.navController
        drawerlayout=binding.appDrawer
        binding.navigationView.setupWithNavController(navController)
        binding.bottomNavView.setupWithNavController(navController)
        appbarconfiguration= AppBarConfiguration(navController.graph,drawerlayout)
        setupActionBarWithNavController(navController,appbarconfiguration)
        val badge =binding.bottomNavView.getOrCreateBadge(R.id.mainActivity)
        badge.isVisible = true
        badge.number = 99
        listener=NavController.OnDestinationChangedListener { controller, destination, arguments ->
        }

    }

    override fun onPause() {
        super.onPause()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navcontroller=findNavController(R.id.fragment_container_view)
        return  navcontroller.navigateUp(appbarconfiguration) || super.onSupportNavigateUp()
    }
}