package com.example.wada_ryosuke.qiitaclient.main

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.wada_ryosuke.qiitaclient.R

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var uri = intent.data
        Log.d(TAG, "code : ${uri.getQueryParameter("code")}")
        Log.d(TAG, "state : ${uri.getQueryParameter("state")}")
    }
}