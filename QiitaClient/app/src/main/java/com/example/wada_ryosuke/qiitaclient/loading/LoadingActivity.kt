package com.example.wada_ryosuke.qiitaclient.loading

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.wada_ryosuke.qiitaclient.R
import com.example.wada_ryosuke.qiitaclient.common.HttpClient
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl

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
        val single = Single.create<Bitmap> {
            doAuthenticate("hoge")
        }
                .subscribeOn(Schedulers.newThread())

        single.subscribe()
    }

    private fun getParameters(): QueryParams {
        val uri = intent.data
        return QueryParams(
                uri.getQueryParameter("code"),
                uri.getQueryParameter("state")
        )
    }

    private fun doAuthenticate(code: String) {
        val queryObserver = HttpClient.get(HttpUrl.get("http://httpbin.org/get"))
        queryObserver.doOnNext {
            Log.d("Response body", it.body()!!.string())
        }.doOnError{
            Log.e("Query Error", it.localizedMessage)
        }.subscribe()
    }


}