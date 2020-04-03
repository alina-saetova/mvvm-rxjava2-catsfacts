package ru.itis.cats_facts.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import ru.itis.cats_facts.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatApiInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url()
            .newBuilder()
            .addQueryParameter("api_key",
                BuildConfig.PIC_API_KEY
            )
            .addQueryParameter("limit", "30")
            .build()
        val request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
