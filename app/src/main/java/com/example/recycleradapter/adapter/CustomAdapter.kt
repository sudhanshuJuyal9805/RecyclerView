package com.example.recycleradapter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleradapter.model.UserItem
import com.example.recycleradapter.databinding.ItemViewBinding

class CustomAdapter :RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{
    private lateinit var binding : ItemViewBinding
    private var checkOutList = ArrayList<UserItem>()


    class ViewHolder(private val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: ArrayList<UserItem>){
            binding.textView.text=data[0].title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setCheckOutListData(checkoutList : ArrayList<UserItem>){
        this.checkOutList = checkoutList
        notifyDataSetChanged()


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val  itemData = checkOutList
        holder.bind(itemData)
    }

    override fun getItemCount(): Int {
      return  checkOutList.size
    }

}