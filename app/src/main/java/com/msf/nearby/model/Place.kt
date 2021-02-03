package com.msf.nearby.model


import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("geometry")
    val geometry: Geometry,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("opening_hours")
    val openingHours: OpeningHours,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("reference")
    val reference: String,
    @SerializedName("types")
    val types: List<String>,
    @SerializedName("vicinity")
    val vicinity: String
)