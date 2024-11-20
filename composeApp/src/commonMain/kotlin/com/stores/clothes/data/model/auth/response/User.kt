package com.stores.clothes.data.model.auth.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("accessToken")
    val accessToken: String?,
    @SerialName("activation_code")
    val activationCode: Int?,
    @SerialName("addresses")
    val addresses: List<Addresse>?,
    @SerialName("avatar")
    val avatar: String?,
    @SerialName("country")
    val country: Country?,
    @SerialName("country_id")
    val countryId: Int?,
    @SerialName("email")
    val email: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("mobile")
    val mobile: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("status")
    val status: String?
)