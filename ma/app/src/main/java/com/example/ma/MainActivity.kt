package com.example.ma

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.ma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var howmany=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        createNotification()
        binding.button.setOnClickListener {
            howmany+=1;
            showNotification(howmany)
        }
    }
    private val channelId="normal"
    private fun createNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel=NotificationChannel(channelId,"default channel", NotificationManager.IMPORTANCE_DEFAULT)
        channel.description="description text of this channel"
            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel);
        }
    }
    fun showNotification(howmany:Int){
      val builder=with(NotificationCompat.Builder(this,channelId))
      {
          setSmallIcon((R.mipmap.ic_launcher))
          setContentTitle(howmany.toString())
      }
        NotificationManagerCompat.from(this).notify(1,builder.build())
    }
}