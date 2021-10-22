package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.myapplication.databinding.ActivityNewDrawerBinding

class NewDrawerActivity : AppCompatActivity() {
    private lateinit var appbarc : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nhf = supportFragmentManager.findFragmentById(R.id.fragment2) as NavHostFragment
        val topDest = setOf(R.id.homeFragment, R.id.secondFragment, R.id.thirdFragment)
        appbarc = AppBarConfiguration(topDest, binding.drawerLayout)
        setupActionBarWithNavController(nhf.navController, appbarc)
        binding.naviview.setNavigationItemSelectedListener {
            binding.drawerLayout.close()
            when (it.itemId) {
                R.id.callAction -> {
                    startActivity(Intent().setAction(Intent.ACTION_DIAL))
                    true
                }
                else -> {
                    it.onNavDestinationSelected(nhf.navController)
                }
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment2).navigateUp(appbarc)||super.onSupportNavigateUp()
    }
}