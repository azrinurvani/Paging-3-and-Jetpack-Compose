package com.azrinurvani.paging3andjetpackcompose.di

import com.azrinurvani.paging3andjetpackcompose.Constants.BASE_URL
import com.azrinurvani.paging3andjetpackcompose.data.remote.UnsplashApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient() : OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(15,TimeUnit.SECONDS)
            .connectTimeout(15,TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient) : Retrofit{
        val contentType = MediaType.get("application/json")
        val json = Json{
            ignoreUnknownKeys = true // untuk mengabaikan field lain dari response ketika tidak digunakan
        }
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            //menggunakan json.asConverterFactory karena menggunakan kotlinx.serialization
            .build()
    }

    @Provides
    fun provideUnsplashApi(retrofit: Retrofit) : UnsplashApi{
        return retrofit.create(UnsplashApi::class.java)
    }

}