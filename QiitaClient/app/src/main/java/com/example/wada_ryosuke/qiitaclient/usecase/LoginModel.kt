package com.example.wada_ryosuke.qiitaclient.usecase

import android.content.Intent
import android.net.Uri
import com.example.wada_ryosuke.qiitaclient.view.activities.LoginActivity

class LoginModel(val mActivity: LoginActivity) {
    fun doLogin() {
        val uri = "https://qiita.com/api/v2/oauth/authorize?" +
                "client_id=690c6c96a29e14b18ec611eb4bd7a4a17ec2da01" +
                "&scope=read_qiita write_qiita"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        mActivity.startActivity(intent)
    }
}