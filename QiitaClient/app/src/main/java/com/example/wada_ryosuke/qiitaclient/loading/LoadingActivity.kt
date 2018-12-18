package com.example.wada_ryosuke.qiitaclient.loading

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.wada_ryosuke.qiitaclient.R

class LoadingActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = LoadingActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
    }
}