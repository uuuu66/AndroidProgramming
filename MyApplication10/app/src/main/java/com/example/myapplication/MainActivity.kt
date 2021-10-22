package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.ChangeBounds
import androidx.transition.Scene
import androidx.transition.TransitionManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var s1:Scene
    private lateinit var s2:Scene
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        s1= Scene.getSceneForLayout(binding.rootScene,R.layout.startlayout,this)
        s2= Scene.getSceneForLayout(binding.rootScene,R.layout.endlayout,this)
        binding.rg1.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                binding.radioButton.id->TransitionManager.go(s1,ChangeBounds())
                binding.radioButton2.id->TransitionManager.go(s2,ChangeBounds())
            }
        }
    }
}