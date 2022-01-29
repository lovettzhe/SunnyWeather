package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * Created by YaoRuiheng on 2022/1/29.
 */
data class PlaceResponse(
    val status: String,
    val places: List<Place>
)

data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)

data class Location(
    val longitude: String,
    val latitude: String
)
