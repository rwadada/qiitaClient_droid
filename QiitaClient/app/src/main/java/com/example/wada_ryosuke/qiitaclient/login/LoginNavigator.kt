package com.example.wada_ryosuke.qiitaclient.login

import android.view.View

interface LoginNavigator {
    fun onLoginButtonClick(v: View)
    fun onGuestButtonClick(v: View)
}