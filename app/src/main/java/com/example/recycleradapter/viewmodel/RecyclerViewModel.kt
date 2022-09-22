package com.example.recycleradapter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.recycleradapter.model.User
import com.example.recycleradapter.repository.Repository

class RecyclerViewModel(private val repository: Repository) : ViewModel()
{

    val user: LiveData<User> get() = repository.user

    init {

         repository.getUser()

//        val monAttDao = MyRoomDatabase.getDbInstance(getApplication()).monthlyAttenDao()
//        monthlyAttendanceRepository = MonthlyAttendanceRepository(monAttDao)
//        viewModelScope.launch(Dispatchers.IO) {
//            getTodayCheckOutData = monthlyAttendanceRepository.readDataForMonth("",util.getMonthAndYear().toString())
        }
    }
