package com.stores.clothes.data.model.auth.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)