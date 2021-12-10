package com.example.myapplication.tp4.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.myapplication.tp4.model.Tp4Room
import com.example.myapplication.tp4.model.Tp4Ui
import com.example.myapplication.tp4.repository.Tp4QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Tp4ViewModel : ViewModel() {

    private val mTp4QuoteRepository: Tp4QuoteRepository by lazy { Tp4QuoteRepository() }
    var mTp4QuoteLiveData: LiveData<List<Tp4Ui>> =
        mTp4QuoteRepository.selectAllTp4Quote().map {
            it.toUi()
        }


    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            mTp4QuoteRepository.fetchData()
        }
    }




    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mTp4QuoteRepository.deleteAllTp4Quote()
        }
    }
}


    private fun List<Tp4Room>.toUi(): List<Tp4Ui> {
        return asSequence().map {
            Tp4Ui(
                full_address = it.full_address,
                city = it.city
            )
        }.toList()
}