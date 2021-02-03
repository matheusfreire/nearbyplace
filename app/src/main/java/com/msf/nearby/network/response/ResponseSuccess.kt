package com.msf.nearby.network.response


import com.google.android.libraries.places.api.model.Place
import com.google.gson.annotations.SerializedName

data class ResponseSuccess(
    @SerializedName("html_attributions")
    val htmlAttributions: List<Any>,
    @SerializedName("results")
    val places: List<Place>,
    @SerializedName("status")
    val status: String
)