package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
var x : Int =0
class MainActivity : AppCompatActivity() {
    override fun onCreate(dat: Bundle?) {
        x=0
        super.onCreate(dat)
        setContentView(R.layout.activity_main)
        val tv=findViewById<Button>(R.id.button1)
        tv.text="학번1414028"

        tv.setOnClickListener{
            x+=1
            tv.text= "test" + x.toString()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        println("destroyed")
    }
}