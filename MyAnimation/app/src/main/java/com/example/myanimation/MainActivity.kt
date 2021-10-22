package com.example.myanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.Scene
import androidx.transition.TransitionManager
import android.widget.RadioGroup
import androidx.transition.ChangeBounds
import com.example.myanimation.databinding.MainlayoutBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:MainlayoutBinding
    private lateinit var scene1:Scene
    private lateinit var scene2:Scene
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=MainlayoutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        scene1= Scene.getSceneForLayout(binding.sceneRoot,R.layout.startlayout,this)
        scene2= Scene.getSceneForLayout(binding.sceneRoot,R.layout.endlayout,this)
        radioGroup=binding.rg1
        radioGroup.setOnCheckedChangeListener{group,id->
            when(id){
                binding.rb1.id->TransitionManager.go(scene1,ChangeBounds())
                binding.rb2.id->TransitionManager.go(scene2,ChangeBounds())
            }
        }
    }

}