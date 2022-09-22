package com.example.recycleradapter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recycleradapter.repository.Repository

class MainViewModelFactory(private var repository: Repository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RecyclerViewModel(repository) as T
    }
}