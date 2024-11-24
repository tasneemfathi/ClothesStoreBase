package com.stores.clothes.data.model.auth.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Addresse(
    @SerialName("address_number")
    val addressNumber: String?,
    @SerialName("apartment_number")
    val apartmentNumber: String?,
    @SerialName("city")
    val city: City?,
    @SerialName("country")
    val country: Country?,
    @SerialName("district_name")
    val districtName: String?,
    @SerialName("floor_number")
    val floorNumber: String,
    @SerialName("full_address")
    val fullAddress: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("international_address")
    val internationalAddress: String?,
    @SerialName("latitude")
    val latitude: Double?,
    @SerialName("longitude")
    val longitude: Double?,
    @SerialName("name")
    val name: String?,
    @SerialName("others")
    val others: String?,
    @SerialName("street")
    val street: String?
)