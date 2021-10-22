package com.example.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.myfragment.databinding.ActivityMainBinding
import com.example.myfragment.databinding.ExampleFragBinding
import com.example.myfragment.databinding.ExampleFragment2Binding
import com.example.myfragment.databinding.HomeFragmentBinding

class MyViewModel : ViewModel(){
    val testLiveData = MutableLiveData<Int>()
    init {
        testLiveData.value=0
    }
    fun increase(){
        testLiveData.value=(testLiveData.value ?:0 )+1
    }
    fun getValue(): String? {
        return testLiveData.value.toString()
    }
}
class ExampleFragment: Fragment(R.layout.example_frag){
    val viewModel:MyViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=ExampleFragBinding.bind(view)
        binding.button.setOnClickListener({
           viewModel.increase()
            findNavController().navigate(R.id.action_exampleFragment_to_exampleFragment2)
        })
        viewModel.testLiveData.observe(viewLifecycleOwner){
            binding.nav1Lives.text=viewModel.getValue()
        }
    }
}

class ExampleFragment2: Fragment(R.layout.example_fragment2){
    val viewModel:MyViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=ExampleFragment2Binding.bind(view)
        binding.button3.setOnClickListener({
            viewModel.increase()
            findNavController().navigate(R.id.action_exampleFragment2_to_homeFragment)
        })
        viewModel.testLiveData.observe(viewLifecycleOwner){
            binding.nav2Lives.text=viewModel.getValue()
        }
    }
}
class HomeFragment: Fragment(R.layout.home_fragment) {
    val viewModel:MyViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=HomeFragmentBinding.bind(view)
        binding.button2.setOnClickListener({
            viewModel.increase()
            findNavController().navigate(R.id.action_homeFragment_to_exampleFragment)
        })
        viewModel.testLiveData.observe(viewLifecycleOwner){
            binding.homeLives.text=viewModel.getValue()
        }
    }
}
class MainActivity : AppCompatActivity() {
    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    val viewModel:MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}