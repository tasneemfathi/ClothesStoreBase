package com.stores.clothes.data.model.auth.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerifyRequest(
    val mobile: String,
    @SerialName("country_id")
    val countryId: String,
    val code: String
)