package com.example.myapplication.tp4.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.architecture.CustomApplication
import com.example.myapplication.architecture.RetrofitBuilder
import com.example.myapplication.tp4.model.Tp4Retrofit
import com.example.myapplication.tp4.model.Tp4Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Tp4QuoteRepository {
    private val mTp4Dao = CustomApplication.instance.mApplicationDatabase.tp4Dao()

    fun selectAllTp4Quote(): LiveData<List<Tp4Room>> {
        return mTp4Dao.selectAll()
    }


    private suspend fun insertTp4Quote(Tp4Quote: Tp4Room) =
        withContext(Dispatchers.IO) {
            mTp4Dao.insert(Tp4Quote)
        }


    suspend fun deleteAllTp4Quote() = withContext(Dispatchers.IO) {
        mTp4Dao.deleteAll()
    }


    suspend fun fetchData() {
        insertTp4Quote(RetrofitBuilder.getTp4Quote().getRandomQuote().toRoom())
    }
}


private fun Tp4Retrofit.toRoom(): Tp4Room {
    return Tp4Room(
        full_address = full_address,
        city = city
    )
}
