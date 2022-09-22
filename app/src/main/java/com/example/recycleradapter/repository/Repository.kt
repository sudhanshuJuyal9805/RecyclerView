package com.example.recycleradapter.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recycleradapter.model.User
import com.example.recycleradapter.api.apiHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(private val apiHelper: apiHelper)
{
    private val _users= MutableLiveData<User>()
    val user: LiveData<User> get() = _users
    fun getUser()
    {
        CoroutineScope(Dispatchers.IO).launch {
            val res=apiHelper.getUsers()
            _users.postValue(res.body())
        }
    }
}