package com.example.wada_ryosuke.qiitaclient.common

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import com.example.wada_ryosuke.qiitaclient.R
import okhttp3.*
import org.json.JSONObject
import java.util.concurrent.TimeUnit

@SuppressLint("StaticFieldLeak")
object APIManager {

    private val TAG: String = APIManager::class.java.simpleName

    private var client = OkHttpClient()
    private val mediaType = MediaType.parse("application/json")
    private lateinit var mActivity: Activity

    fun setActivity(mActivity: Activity) {
        this.mActivity = mActivity
    }

    fun getAccessToken(code: String) :String{
        val requestStr: String = JSONObject()
                .put("client_id", mActivity.getString(R.string.client_id))
                .put("client_secret", mActivity.getString(R.string.client_secret))
                .put("code", code)
                .toString()

        val requestBody = RequestBody.create(mediaType, requestStr)

        val request = Request.Builder()
                .url(mActivity.getString(R.string.qiita_api_url)+mActivity.getString(R.string.authorization_api))
                .post(requestBody)
                .build()

        val response = client.newCall(request).execute()

        Log.d(TAG, response.body()?.string())

        return ""
    }
}