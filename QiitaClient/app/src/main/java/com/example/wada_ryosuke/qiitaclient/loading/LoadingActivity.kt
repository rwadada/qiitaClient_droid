package com.example.wada_ryosuke.qiitaclient.loading

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.wada_ryosuke.qiitaclient.R

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class LoadingActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = LoadingActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        val queryParams = getParameters()
        Log.d(TAG, queryParams.code)
        Log.d(TAG, queryParams.state)
    }

    private fun getParameters(): QueryParams {
        val uri = intent.data
        return QueryParams(
                uri.getQueryParameter("code"),
                uri.getQueryParameter("state")
        )
    }


}