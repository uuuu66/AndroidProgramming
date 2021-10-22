package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    fun getPref () {

        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        val signature = settings.getString("signature", "")
        val reply = settings.getString("reply", "")
        val sync = settings.getBoolean("sync", false)
        val attachment = settings.getBoolean("attachment", false)
        val str =
            """
            signature: $signature
            reply: $reply
            sync: $sync
            attachment: $attachment
            """
        binding.textView.text = str


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPref()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onResume() {
        super.onResume()
        getPref()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings->startActivity(Intent(this,SettingsActivity::class.java))
            else->super.onOptionsItemSelected(item)
        }
        return true
    }
}