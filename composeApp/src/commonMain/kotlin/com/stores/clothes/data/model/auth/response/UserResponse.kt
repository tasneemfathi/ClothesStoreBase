package com.stores.clothes.data.model.auth.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("response_message")
    val responseMessage: String,
    @SerialName("status")
    val status: Boolean,
    @SerialName("user")
    val user: User
)