package com.stores.clothes.data.model.config.countries


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountriesResponse(
    @SerialName("countries")
    val countries: List<Country>,
    @SerialName("response_message")
    val responseMessage: String,
    @SerialName("status")
    val status: Boolean
)