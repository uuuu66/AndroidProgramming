package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            binding.textView2.text=binding.editTextTextPersonName.text
            val pet="${resources.getStringArray(R.array.animal)[0]}:${binding.radiocat.isChecked},${resources.getStringArray(R.array.animal)[1]}:${binding.radiodog.isChecked}"
            Snackbar.make(it,pet,Snackbar.LENGTH_SHORT).show()

             when(binding.radioGroup.checkedRadioButtonId){
                 R.id.radiodog->println("dog checked")
                 R.id.radiocat->println("cat checked")
             }
        }
    }
}