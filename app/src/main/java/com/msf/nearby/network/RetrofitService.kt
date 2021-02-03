package com.msf.nearby.network

import com.google.gson.GsonBuilder
import com.msf.nearby.BuildConfig
import com.msf.nearby.network.interfaces.PlaceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val instance: PlaceApi by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()

        // Create Retrofit client
        return@lazy retrofit.create(PlaceApi::class.java)
    }

}