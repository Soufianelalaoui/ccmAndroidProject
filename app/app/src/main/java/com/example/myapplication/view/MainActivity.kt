package com.example.myapplication.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseUser
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.tp4.view.Tp4Activity
import com.example.myapplication.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mViewModel: MainViewModel

    @SuppressLint("SetTextI18n")
    private var mObserverUser = Observer<FirebaseUser> {
        if(it == null ){
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else{
            binding.user.text = "utilisateur :" + it.email
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        //bindind des action des boutons
        binding.buttonDeconnexion.setOnClickListener{signOut()}


        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.version.text = "Version :" + mViewModel.mCurrentVersion.toString()
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        mViewModel.mCurrentUser.observe(this, mObserverUser)
    }

    fun signOut(){
        mViewModel.disconnectUser()
    }

    override fun onStop() {
        super.onStop()
        mViewModel.mCurrentUser.removeObserver(mObserverUser)
    }

    fun onClickOpenRecyclerView(view: View) {
        val intent = Intent(this, Tp4Activity::class.java)
        startActivity(intent)
    }
}