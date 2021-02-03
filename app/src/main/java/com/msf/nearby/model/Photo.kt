package com.msf.nearby.model


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("height")
    val height: Int,
    @SerializedName("html_attributions")
    val htmlAttributions: List<Any>,
    @SerializedName("photo_reference")
    val photoReference: String,
    @SerializedName("width")
    val width: Int
)