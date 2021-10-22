package com.example.myapplication

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private var myService :MyService? =null
    private val ServiceConnection= object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            myService=(service as MyService.LocalBinder).getService()

        }

        override fun onServiceDisconnected(name: ComponentName?) {
          myService=null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonss.setOnClickListener{
        Intent(this,MyService::class.java).also{
            myService?.doService("hello")
        }
         }
        binding.buttonub.setOnClickListener {

            unbindService(ServiceConnection)
            myService=null
            binding.buttonss.isEnabled = false
            binding.buttonub.isEnabled = false
            binding.buttonob.isEnabled= true
        }
        binding.buttonob.setOnClickListener {
            Intent(this,MyService::class.java).also{
                bindService(it,ServiceConnection, BIND_AUTO_CREATE)
                binding.buttonss.isEnabled = true
                binding.buttonub.isEnabled = true
                binding.buttonob.isEnabled= false
            }
        }


    }

}