package com.example.recycleradapter.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.recycleradapter.model.Model
import com.example.recycleradapter.model.User
import com.example.recycleradapter.repository.Repository

class RecyclerViewModel(private val repository: Repository) : ViewModel()
{

    val user: LiveData<ArrayList<Model>> get() = repository.user

    init {
         repository.getUser()
        }
    fun onClickData(postion:Int)
    {
        Log.d("TAG",postion.toString())
    }

    }
