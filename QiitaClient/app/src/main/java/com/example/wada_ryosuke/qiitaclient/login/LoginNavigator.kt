package com.example.wada_ryosuke.qiitaclient.login

import android.view.View

interface LoginNavigator {
    public fun onLoginButtonClick(v: View)
    public fun onGuestButtonClick(v: View)
}