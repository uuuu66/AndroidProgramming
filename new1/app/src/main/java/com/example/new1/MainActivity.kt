package com.example.new1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.new1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    val TAG="Lifecycle-test"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"onCreate")
        val button=binding.button
        var viewModel=ViewModelProvider(this).get(MyViewModel::class.java)

        button.setOnClickListener{
            val intent= Intent(this,SecondActivity::class.java)
            var inputValueText= binding.editText
            viewModel.setHak(inputValueText.text.toString())
            intent.putExtra("M",inputValueText.text.toString())

            startActivityForResult(intent,1)
        }
        var dialButton=findViewById<Button>(R.id.button2)
        dialButton.setOnClickListener{
            val implicitIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))
            startActivity(implicitIntent)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val msg = data?.getStringExtra("ResultString") ?: ""
            Snackbar.make(binding.root, "ActivityResult:$resultCode $msg",
                    Snackbar.LENGTH_SHORT).show()
            Log.i(TAG, "ActivityResult:$resultCode $msg")
        }
        Log.d(TAG,"onActivityResult()")
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