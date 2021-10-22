package com.example.myapplication



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appbarc :AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nhf=supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

      appbarc= AppBarConfiguration(nhf.navController.graph)
        setupActionBarWithNavController(nhf.navController,appbarc)
    binding.button.setOnClickListener(){
        startActivity(Intent(this,NewDrawerActivity::class.java))
    }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
       return findNavController(R.id.fragment).navigateUp(appbarc)||super.onSupportNavigateUp()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.homeFragment ->item.onNavDestinationSelected(findNavController(R.id.fragment))
            R.id.secondFragment ->item.onNavDestinationSelected(findNavController(R.id.fragment))
            R.id.thirdFragment ->item.onNavDestinationSelected(findNavController(R.id.fragment))
            else ->return super.onOptionsItemSelected(item)
        }
    return true
    }
}