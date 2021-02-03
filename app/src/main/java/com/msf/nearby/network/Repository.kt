package com.msf.nearby.network

import com.google.gson.Gson
import com.msf.nearby.network.response.NetworkResponse
import com.msf.nearby.network.response.ResponseSuccess
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun fetchPlaces(type: String,handleReturn: (receiptResponse: NetworkResponse?) -> Unit) {
        RetrofitService.instance.fetchPlaces(type)
            .enqueue(object : Callback<ResponseSuccess> {
                override fun onResponse(call: Call<ResponseSuccess>,response: Response<ResponseSuccess>) {
                    if (response.isSuccessful){
                        handleReturn(createReceiptResponse(true, response.body()))
                    } else {
                        handleReturn(createReceiptResponse(false, null))
                    }
                }
                override fun onFailure(call: Call<ResponseSuccess>, t: Throwable) {
                    handleReturn(createReceiptResponse(false, null))
                }

            })
    }

    private fun createReceiptResponse(isSuccess: Boolean, success: ResponseSuccess?) : NetworkResponse{
        return NetworkResponse(isSuccess, success)
    }
}