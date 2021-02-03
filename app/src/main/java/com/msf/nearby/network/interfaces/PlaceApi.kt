package com.msf.nearby.network.interfaces

import com.msf.nearby.network.response.ResponseSuccess
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceApi {

    @GET
    fun fetchPlaces(@Query("type") type: String) : Call<ResponseSuccess>

}