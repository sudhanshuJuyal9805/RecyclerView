package com.example.recycleradapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleradapter.adapter.CustomAdapter
import com.example.recycleradapter.api.ApiClient
import com.example.recycleradapter.api.apiHelper
import com.example.recycleradapter.databinding.ActivityMainBinding
import com.example.recycleradapter.repository.Repository
import com.example.recycleradapter.viewmodel.MainViewModelFactory
import com.example.recycleradapter.viewmodel.RecyclerViewModel

class MainActivity : AppCompatActivity() ,InterfaceRecyclerview{
    private lateinit var mainActivityViewModel: RecyclerViewModel
    private lateinit var binding: ActivityMainBinding
    private var adapter = CustomAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val api= ApiClient.getApiClient().create(apiHelper::class.java)
        val repository= Repository(api)
        mainActivityViewModel = ViewModelProvider(this, MainViewModelFactory(repository))[RecyclerViewModel::class.java]
        setCheckoutListData()

    }

    fun setCheckoutListData() {
        binding.myAdapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
        mainActivityViewModel.user.observe(this, Observer {
            Log.d("TAG", "setCheckoutListData: ${it.toString()}")

            adapter.setCheckOutListData(it)
        })

    }

    override fun onItemClick(position: Int)
    {
        mainActivityViewModel.onClickData(position)
        Toast.makeText(this,position.toString(),Toast.LENGTH_LONG).show()

    }
}