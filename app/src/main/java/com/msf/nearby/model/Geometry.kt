package com.msf.nearby.model


import com.google.gson.annotations.SerializedName

data class Geometry(
    @SerializedName("location")
    val location: Location
)