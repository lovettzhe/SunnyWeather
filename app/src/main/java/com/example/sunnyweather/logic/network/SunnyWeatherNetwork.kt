package com.example.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 定义一个统一的网络数据源访问入口，对所有网络请求的API进行封装
 * Created by YaoRuiheng on 2022/1/29.
 */
object SunnyWeatherNetwork {
    /**
     * 创建PlaceService接口的动态代理对象
     */
    private val placeService = ServiceCreator.create<PlaceService>()

    /**
     * 发起搜索城市数据请求
     * @param query String
     * @return PlaceResponse
     */
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine {
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) {
                        it.resume(body)
                    } else {
                        it.resumeWithException(RuntimeException("Response body is null."))
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }
            })
        }
    }
}