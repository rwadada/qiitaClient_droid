package com.example.wada_ryosuke.qiitaclient.common

import org.junit.Test
import org.assertj.core.api.Assertions.*

class UrlBuilderTest {

    @Test
    fun setUrl() {
        assertThat(UrlBuilder().setUrl("")).isNotNull()
    }

    @Test
    fun setParameter() {
        assertThat(UrlBuilder().setParameter("","")).isNotNull()
    }

    @Test
    fun build() {
        val url = "http://google.com"
        val builder = UrlBuilder()
                .setUrl(url)
                .setParameter("param1", "hoge")
                .setParameter("param2", "fuga")

        assertThat(builder.build()).isEqualTo("http://google.com?param1=hoge&param2=fuga")
    }
}