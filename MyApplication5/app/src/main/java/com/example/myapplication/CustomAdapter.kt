package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLayoutBinding


class CustomAdapter(private val viewModel: MyViewModel) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemLayoutBinding) :RecyclerView.ViewHolder(binding.root){
        fun setContents(pos:Int){
           with (viewModel.items[pos]){
                binding.textView1.text=name
               binding.textView2.text=phone
            }
            binding.root.setOnLongClickListener{
                viewModel.longClickItem = pos
                false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val binding=ItemLayoutBinding.inflate(layoutInflater,parent,false)
        //val view =layoutInflater.inflate(R.layout.item_layout,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setContents(position)
    }

    override fun getItemCount()=viewModel.items.size
}