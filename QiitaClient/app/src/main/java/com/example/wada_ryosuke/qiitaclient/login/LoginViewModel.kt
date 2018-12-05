package com.example.wada_ryosuke.qiitaclient.login

import android.content.Intent
import android.net.Uri
import com.example.wada_ryosuke.qiitaclient.R
import com.example.wada_ryosuke.qiitaclient.common.UrlBuilder
import com.example.wada_ryosuke.qiitaclient.main.MainActivity

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
        val intent = Intent(mActivity, MainActivity.javaClass)
        mActivity.startActivity(intent)
    }
}