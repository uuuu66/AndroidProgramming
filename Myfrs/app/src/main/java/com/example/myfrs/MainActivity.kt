package com.example.myfrs
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(dat: Bundle?) {
        super.onCreate(dat)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.textView)
        tv.text = "Hello Android"
    }

    override fun onDestroy() {
        super.onDestroy()
        println("destroyed")
    }
}