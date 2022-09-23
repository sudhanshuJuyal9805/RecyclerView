package com.example.recycleradapter.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recycleradapter.model.User
import com.example.recycleradapter.api.apiHelper
import com.example.recycleradapter.model.Model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(private val apiHelper: apiHelper)
{
    private val _users= MutableLiveData<ArrayList<Model>>()
    private var  list=ArrayList<Model>()
    val user: LiveData<ArrayList<Model>> get() = _users
    fun getUser()
    {
        CoroutineScope(Dispatchers.IO).launch {
            val res=apiHelper.getUsers()
            for (i in 1..10) {
                list.add(Model(i.toString()))

            }
            _users.postValue(list)
        }
    }
}