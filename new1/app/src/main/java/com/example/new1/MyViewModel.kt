package com.example.new1
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class MyViewModel : ViewModel(){
    var count=1
    val indexHak: MutableLiveData<Int> = MutableLiveData<Int>()
    init {
        indexHak.value = 0

    }
    fun setHak(data:String){
        indexHak.value =Integer.parseInt(data)
    }
    fun increaseHak(){
        indexHak.value=(indexHak.value?:0)+1
    }
    fun decreaseHak(){
        indexHak.value=(indexHak.value?:0)-1
    }
}