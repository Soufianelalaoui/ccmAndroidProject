package com.example.myapplication.repository

import com.example.myapplication.BuildConfig

class VersionRepository {

    fun getVersion() : Int {
        return BuildConfig.VERSION_CODE;
    }
}