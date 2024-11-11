package ro.fcrapid.fcrapidjetpack.app_services.adapters.network

import android.content.Context
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClientFactory {
    fun create(context: Context): Retrofit {
        val client = okHttpClient(context)
        return Retrofit.Builder()
            .baseUrl("https://662f244a43b6a7dce30e7f2a.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    private fun okHttpClient(context: Context): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .writeTimeout(45, TimeUnit.SECONDS)
            .addInterceptor(OkHttpProfilerInterceptor())
        return builder.build()
    }
}