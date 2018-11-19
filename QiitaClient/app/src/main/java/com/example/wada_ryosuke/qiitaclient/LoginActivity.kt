package com.example.wada_ryosuke.qiitaclient

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.wada_ryosuke.qiitaclient.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //レイアウトをmActivityLoginBindingにバインドする。
        var mActivityLoginBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        //ボタンに表示するテキストを設定
        mActivityLoginBinding.guestButton.setText("Guest")
        mActivityLoginBinding.loginButton.setText("Login")
    }
}
