package com.example.wada_ryosuke.qiitaclient.loading

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.wada_ryosuke.qiitaclient.R
import com.example.wada_ryosuke.qiitaclient.common.AppData
import com.example.wada_ryosuke.qiitaclient.common.HttpClient
import com.example.wada_ryosuke.qiitaclient.main.MainActivity
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONException
import org.json.JSONObject

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

        doAuthenticate(queryParams.code)
    }

    private fun getParameters(): QueryParams {
        val uri = intent.data
        return QueryParams(
                uri.getQueryParameter("code"),
                uri.getQueryParameter("state")
        )
    }

    private fun doAuthenticate(code: String? = "") {
        var access_token = ""

        val requestStr: String = JSONObject()
                .put("client_id", getString(R.string.client_id))
                .put("client_secret", getString(R.string.client_secret))
                .put("code", code)
                .toString()
        val url: HttpUrl = HttpUrl.get(getString(R.string.qiita_api_url) + getString(R.string.authorization_api))
        val mediaType: MediaType = MediaType.parse("application/json")!!
        val requestBody: RequestBody = RequestBody.create(mediaType, requestStr)
        val queryObserver = HttpClient.post(url = url, requestBody = requestBody)
                .subscribeOn(Schedulers.newThread())

        queryObserver.doOnNext { it ->
            val resString = it.body()!!.string()
            Log.d("Response body", resString)
            try {
                val response = JSONObject(resString)
                access_token = response.getString("token")
                AppData.setAccess_token(access_token)
                val intent: Intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
                this.finish()

            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }.doOnError { it ->
            Log.e("Query Error", it.localizedMessage)
        }.subscribe()
    }

}