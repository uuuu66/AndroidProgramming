package com.example.new1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.new1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val TAG="Lifecycle-Second"
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"onCreate")
        val v=intent?.getStringExtra("M")
        val tv=binding.tv
        var viewModel= ViewModelProvider(this).get(MyViewModel::class.java)

        binding.radioButton.text=resources.getStringArray(R.array.foods)[0]
        binding.radioButton2.text=resources.getStringArray(R.array.foods)[1]
        viewModel.indexHak.observe(this){
            tv.text=viewModel.indexHak.value.toString()

        }
        viewModel.setHak(v.toString())


        var increaseBtn=binding.button3
        var decreaseBtn=binding.button4
        increaseBtn.setOnClickListener{
           viewModel.increaseHak()

        }
        decreaseBtn.setOnClickListener{
            viewModel.decreaseHak()

        }


    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onBackPressed() {
        var resultIntent=Intent()
       var tv=binding.tv
        resultIntent.putExtra("ResultString", tv.text.toString())

        Log.d(TAG,"onBackPressed()")
        setResult(1234,resultIntent)
        super.onBackPressed()
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause()")

    }
}