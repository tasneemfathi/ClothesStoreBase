package com.stores.clothes.data.model.config.countries


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("currency")
    val currency: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("mobile_digits")
    val mobileDigits: Int,
    @SerialName("name")
    val name: String,
    @SerialName("prefix")
    val prefix: Int,
    @SerialName("status")
    val status: String
)