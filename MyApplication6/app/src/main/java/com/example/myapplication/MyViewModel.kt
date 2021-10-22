package com.example.myapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import java.io.File

class MyViewModel(context: Context) :ViewModel(){
    private val fileInternal = File(context.filesDir,"app.txt")
    private val fileExternal =File(context.filesDir,"appEx.txt")

}