package ru.itis.cats_facts.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.itis.cats_facts.BuildConfig
import ru.itis.cats_facts.data.remote.interceptor.CatApiInterceptor
import ru.itis.cats_facts.data.remote.service.CatFactsService
import ru.itis.cats_facts.data.remote.service.CatPictureService
import ru.itis.cats_facts.data.repository.CatFactRepository
import ru.itis.cats_facts.data.repository.CatFactRepositoryImpl
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    @Named("ok-pictures")
    fun provideCatPicturesOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(CatApiInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    @Named("retrofit-pictures")
    fun provideCatPicturesRetrofit(@Named("ok-pictures") client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.PIC_API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCatPicturesService(@Named("retrofit-pictures") retrofit: Retrofit): CatPictureService {
        return retrofit.create(CatPictureService::class.java)
    }

    @Provides
    @Singleton
    @Named("ok-facts")
    fun provideCatFactsOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    @Named("retrofit-facts")
    fun provideCatFactsRetrofit(@Named("ok-facts") client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.FACTS_API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCatFactsService(@Named("retrofit-facts") retrofit: Retrofit): CatFactsService {
        return retrofit.create(CatFactsService::class.java)
    }
}
