package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.HomefragmentBinding

class MainActivity : AppCompatActivity() {
    val  binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    };
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


    }
}
class DataFragment: Fragment(R.layout.homefragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding= HomefragmentBinding.bind(view)
        binding.button3.setOnClickListener {
            binding.title.setText(resources.getString(R.string.title))
            binding.content.setText(R.string.content)

        }
    }
}