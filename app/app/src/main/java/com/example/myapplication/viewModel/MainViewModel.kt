package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.example.myapplication.repository.FirebaseAuthRepository
import com.example.myapplication.repository.VersionRepository
import kotlin.properties.Delegates

class MainViewModel : ViewModel(){

    private val mFirebaseAuthRepository: FirebaseAuthRepository by lazy { FirebaseAuthRepository() }
    private val mVersionRepository: VersionRepository by lazy { VersionRepository() }
    var mCurrentUser = MutableLiveData<FirebaseUser>()
    var mCurrentVersion : Int

    init {
        mCurrentUser = mFirebaseAuthRepository.mCurrentUser
        mCurrentVersion = mVersionRepository.getVersion()
    }

    fun disconnectUser() {
        mFirebaseAuthRepository.disconnectUser()
    }
}