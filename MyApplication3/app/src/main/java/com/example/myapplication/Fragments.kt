package com.example.myapplication

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentLayoutBinding

class myDialogFragment :DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       return AlertDialog.Builder(requireContext()).apply {
            setTitle("this title")
            setPositiveButton("OK"){dialog,id->println("ok")}
        }.create()
    }
}
class HomeFragment :Fragment(R.layout.fragment_layout){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding=FragmentLayoutBinding.bind(view)
        binding.fragText.text="HomeFragment"
    }
}
class SecondFragment :Fragment(R.layout.fragment_layout){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding=FragmentLayoutBinding.bind(view)
        binding.fragText.text="SecondFragment"
    }
}
class ThirdFragment :Fragment(R.layout.fragment_layout){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding=FragmentLayoutBinding.bind(view)
        binding.fragText.text="ThirdFragment"
    }
}