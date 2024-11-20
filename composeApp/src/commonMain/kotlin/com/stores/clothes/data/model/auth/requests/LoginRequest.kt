package com.stores.clothes.data.model.auth.requests

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val name: String,
    val mobile: String,
    val countryId: String
)