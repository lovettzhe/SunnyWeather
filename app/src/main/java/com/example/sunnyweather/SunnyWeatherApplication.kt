package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * 全局获取Context
 * Created by YaoRuiheng on 2022/1/29.
 */
class SunnyWeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        /**
         * 天气令牌
         */
        const val TOKEN = "qAiFgOOoOeA08JWy"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}