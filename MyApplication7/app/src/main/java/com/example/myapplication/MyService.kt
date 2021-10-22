package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import com.example.myapplication.databinding.ActivityMainBinding

class MyService : Service() {

    private val binder=LocalBinder()
    inner class LocalBinder: Binder(){
    fun getService()=this@MyService
    }
    override fun onBind(intent: Intent): IBinder {
        println("bind service")
        return binder
    }
    fun doService(param: String){
        println(param)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("service start")
        return super.onStartCommand(intent, flags, startId)
    }


    override fun onUnbind(intent: Intent?): Boolean {
        println("unbind service")
        return super.onUnbind(intent)
    }
}