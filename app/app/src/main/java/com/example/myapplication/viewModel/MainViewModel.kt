package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.example.myapplication.repository.FirebaseAuthRepository

class MainViewModel : ViewModel(){

    private val mFirebaseAuthRepository: FirebaseAuthRepository by lazy { FirebaseAuthRepository() }
    var mCurrentUser = MutableLiveData<FirebaseUser>()
    init {
        mCurrentUser = mFirebaseAuthRepository.mCurrentUser
    }

    fun disconnectUser() {
        mFirebaseAuthRepository.disconnectUser()
    }
}