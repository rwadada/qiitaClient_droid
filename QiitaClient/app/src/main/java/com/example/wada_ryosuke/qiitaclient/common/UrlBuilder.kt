package com.example.wada_ryosuke.qiitaclient.common

import java.lang.StringBuilder

class UrlBuilder {
    private val mUrlBuilder: UrlBuilder = this
    private var resultUrl = StringBuilder()
    private var firstFlg = true

    fun setUrl(url: String): UrlBuilder {
        resultUrl.append(url)
        return mUrlBuilder
    }

    fun setParameter(key: String, value: String): UrlBuilder {
        if (firstFlg) {
            resultUrl.append("?$key=$value")
            firstFlg = false
        } else {
            resultUrl.append("&$key=$value")
        }
        return mUrlBuilder
    }

    fun build(): String{
        return resultUrl.toString()
    }
}