package com.example.wada_ryosuke.qiitaclient.login

import android.databinding.DataBindingUtil
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.wada_ryosuke.qiitaclient.R
import com.example.wada_ryosuke.qiitaclient.databinding.ActivityLoginBinding

class LoginViewModel(mActivity: LoginActivity) {
    private val TAG = LoginViewModel::class.java.simpleName
    private val bind: ActivityLoginBinding = DataBindingUtil.setContentView(mActivity, R.layout.activity_login)
    private val loginButton: Button = bind.loginButton
    private val guestButton: Button = bind.guestButton
    private val model = LoginModel(mActivity)

    init {
        bind.setHandler(this)
    }

    fun setLoginButtonText(text: String) {
        loginButton.text = text
    }

    fun setGuestButtonText(text: String) {
        guestButton.text = text
    }

    fun onLoginButtonClick(view: View) {
        Log.d(TAG, "Login button click")
        model.doLogin()
    }

    fun onGuestButtonClick(view: View) {
        Log.d(TAG, "Guest button click")
        model.doGuestLogin()
    }
}