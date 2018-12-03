package com.example.wada_ryosuke.qiitaclient.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.wada_ryosuke.qiitaclient.R
import com.example.wada_ryosuke.qiitaclient.common.UrlBuilder
import com.example.wada_ryosuke.qiitaclient.databinding.ActivityLoginBinding

class LoginViewModel(mActivity: LoginActivity) {
    private val TAG = LoginViewModel::class.java.simpleName
    private val mActivity = mActivity
    fun doLogin() {
        val uri = UrlBuilder().setUrl(mActivity.getString(R.string.qiita_api_url))
                .setUrl(mActivity.getString(R.string.auth_api))
                .setParameter("client_id", mActivity.getString(R.string.client_id))
                .setParameter("scope", "read_qiita write_qiita")
                .setParameter("state", "bb17785d811bb1913ef54b0a7657de780defaa2d")
                .build()

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        mActivity.startActivity(intent)
        mActivity.finish()
    }

    fun doGuestLogin() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("wadada://qiita_client"))
        mActivity.startActivity(intent)
    }
}