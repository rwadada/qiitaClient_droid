package com.example.wada_ryosuke.qiitaclient.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.wada_ryosuke.qiitaclient.R
import com.example.wada_ryosuke.qiitaclient.databinding.ActivityLoginBinding

class LoginViewModel(mActivity: LoginActivity) {
    private val TAG = LoginViewModel::class.java.simpleName
    private val mActivity = mActivity
    fun doLogin() {
        val uri = "https://qiita.com/api/v2/oauth/authorize?" +
                "client_id=690c6c96a29e14b18ec611eb4bd7a4a17ec2da01" +
                "&scope=read_qiita write_qiita" +
                "&state=bb17785d811bb1913ef54b0a7657de780defaa2d"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        mActivity.startActivity(intent)
        mActivity.finish()
    }

    fun doGuestLogin() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("wadada://qiita_client"))
        mActivity.startActivity(intent)
    }
}