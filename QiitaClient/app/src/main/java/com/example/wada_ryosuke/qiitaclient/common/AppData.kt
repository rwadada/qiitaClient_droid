package com.example.wada_ryosuke.qiitaclient.common

import android.app.Application

object AppData: Application() {
    private var access_token: String? = null

    fun setAccess_token(access_token: String) {
        this.access_token = access_token
    }

    fun  getAccess_token(): String =
            if(access_token != null) access_token!!
            else ""
}