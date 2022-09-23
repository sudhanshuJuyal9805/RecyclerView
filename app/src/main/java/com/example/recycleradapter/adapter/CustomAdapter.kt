package com.example.recycleradapter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleradapter.InterfaceRecyclerview
import com.example.recycleradapter.model.UserItem
import com.example.recycleradapter.databinding.ItemViewBinding
import com.example.recycleradapter.model.Model

class CustomAdapter(val interfaceRecyclerview: InterfaceRecyclerview) :RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{
    private lateinit var binding : ItemViewBinding
    private var checkOutList = ArrayList<Model>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val  itemData = checkOutList
        holder.bind(itemData,interfaceRecyclerview,position)

    }

    override fun getItemCount(): Int {
      return  checkOutList.size
    }

    class ViewHolder(private val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: ArrayList<Model>,interfaceRecyclerview: InterfaceRecyclerview,position: Int){
            //binding.textView.text=data[position].texting.toString()
            binding.model = data[position]
            binding.textView.setOnClickListener {
                interfaceRecyclerview.onItemClick(adapterPosition)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCheckOutListData(checkoutList : ArrayList<Model>){
        this.checkOutList = checkoutList
        notifyDataSetChanged()


    }

}