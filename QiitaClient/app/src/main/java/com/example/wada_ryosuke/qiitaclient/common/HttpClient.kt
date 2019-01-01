package com.example.wada_ryosuke.qiitaclient.common

import io.reactivex.Observable
import okhttp3.*
import java.io.IOException

object HttpClient {
    var client: OkHttpClient

    init {
        val builder =OkHttpClient.Builder()
        client = builder.build()
    }

    private fun callObservable(request: Request): Observable<Response> {
        return Observable.create {
            try {
                val response = client.newCall(request).execute()
                it.onNext(response)
                it.onComplete()
            } catch (e: IOException) {
                e.printStackTrace()
                it.onError(e)
            }
        }
    }

    fun get(url: HttpUrl): Observable<Response> {
        val request = Request.Builder()
                .url(url)
                .get()
                .build()
        return callObservable(request)
    }

    fun post(url: HttpUrl, headers: Headers? = null, requestBody: RequestBody): Observable<Response> {
        val request: Request
        if (headers == null) {
            request = Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build()
        } else {
            request = Request.Builder()
                    .url(url)
                    .headers(headers)
                    .post(requestBody)
                    .build()
        }
        return callObservable(request)
    }
}