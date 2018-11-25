package com.example.wada_ryosuke.qiitaclient.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wada_ryosuke.qiitaclient.R

class LoginActivity : AppCompatActivity() {
    companion object {
        private val TAG: String = LoginActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //レイアウトをmActivityLoginBindingにバインドする。
        val loginViewModel = LoginViewModel(this)

        //ボタンに表示するテキストを設定
        loginViewModel.setGuestButtonText("Guest")
        loginViewModel.setLoginButtonText("Login")
    }

}
