package com.example.wada_ryosuke.qiitaclient.view.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.wada_ryosuke.qiitaclient.R

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}