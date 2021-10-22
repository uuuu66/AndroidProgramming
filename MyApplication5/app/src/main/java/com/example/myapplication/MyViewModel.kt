package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Item(val name:String,val phone:String)
class MyViewModel :ViewModel(){
    val items=ArrayList<Item>()
    val itemsLiveData=MutableLiveData<ArrayList<Item>>()

    var longClickItem :Int =-1

    init{
        addItem(Item("tom","010-2313-1231"))
        addItem(Item("james","010-1234-5678"))
    }
     fun addItem(Item:Item){
         items.add(Item)
         itemsLiveData.value=items
     }
    fun updateItem(item: Item,pos:Int){
        items[pos]=item
        itemsLiveData.value=items

    }
    fun deleteItem(pos: Int) {
        items.removeAt(pos)
        itemsLiveData.value = items

    }
}