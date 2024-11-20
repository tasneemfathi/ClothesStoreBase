package com.stores.clothes.data.model.config.config


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigResponse(
    @SerialName("configurations")
    val configurations: Configurations,
    @SerialName("response_message")
    val responseMessage: String,
    @SerialName("status")
    val status: Boolean
)