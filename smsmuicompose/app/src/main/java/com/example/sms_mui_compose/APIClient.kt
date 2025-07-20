package com.example.sms_mui_compose

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit

object APIClient {
    fun get(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.SECONDS)  // ⏱ Customize timeout
            .readTimeout(3, TimeUnit.SECONDS)
            .writeTimeout(3, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                try {
                    chain.proceed(chain.request())
                } catch (e: SocketTimeoutException) {
                    Log.e("ApiClient", "Timeout exception in interceptor", e)

                    throw e  // Still rethrow so you handle it in ViewModel
                } catch (e: IOException) {
                    Log.e("ApiClient", "IO exception in interceptor", e)
                    throw e
                }
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient) // 👈 attach client with timeouts & error logging
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
