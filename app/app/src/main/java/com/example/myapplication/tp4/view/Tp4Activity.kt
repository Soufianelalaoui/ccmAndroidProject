package com.example.myapplication.tp4.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.tp4.model.Tp4Ui
import com.example.myapplication.tp4.viewModel.Tp4ViewModel
import com.example.myapplication.databinding.ActivityTp4Binding

class Tp4Activity : AppCompatActivity() {


    private lateinit var viewModel: Tp4ViewModel
    private lateinit var binding : ActivityTp4Binding
    private val adapter : Tp4Adapter = Tp4Adapter()
    private val observer = Observer<List<Tp4Ui>> {
        adapter.submitList(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTp4Binding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[Tp4ViewModel::class.java]


        binding.Tp4ActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.Tp4ActivityRv.adapter = adapter


        binding.Tp4ActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }


        binding.Tp4ActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }
    override fun onStart() {
        super.onStart()
        viewModel.mTp4QuoteLiveData.observe(this, observer)
    }


    override fun onStop() {
        viewModel.mTp4QuoteLiveData.removeObserver(observer)
        super.onStop()
    }
}


