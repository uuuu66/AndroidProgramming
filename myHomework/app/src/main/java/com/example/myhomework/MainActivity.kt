package com.example.myhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view =findViewById<View>(R.id.view)
        view.setOnClickListener{
            println("hiiii")
        }
    }
}