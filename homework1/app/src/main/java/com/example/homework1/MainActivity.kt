package com.example.homework1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(dat: Bundle?) {
        super.onCreate(dat)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.textview_first)
        tv.text = "Hello Android"
    }

    override fun onDestroy() {
        super.onDestroy()
        println("destroyed")
    }
}