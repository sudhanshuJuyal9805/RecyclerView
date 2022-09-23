package com.example.recycleradapter.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.recycleradapter.model.User
import com.example.recycleradapter.repository.Repository

class RecyclerViewModel(private val repository: Repository) : ViewModel()
{

    val user: LiveData<User> get() = repository.user

    init {
         repository.getUser()
        }
    fun onClickData()
    {
        Log.d("TAG","CLICKED")
    }

    }
