package com.stores.clothes.data.model.config.config


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Configurations(
    @SerialName("active_later_orders")
    val activeLaterOrders: Int,
    @SerialName("address")
    val address: String,
    @SerialName("address_ar")
    val addressAr: String,
    @SerialName("address_en")
    val addressEn: String,
    @SerialName("android")
    val android: String,
    @SerialName("app_status_android")
    val appStatusAndroid: String,
    @SerialName("app_status_ios")
    val appStatusIos: String,
    @SerialName("app_version_android")
    val appVersionAndroid: String,
    @SerialName("app_version_ios")
    val appVersionIos: String,
    @SerialName("application_logo")
    val applicationLogo: String,
    @SerialName("automatic_renewal")
    val automaticRenewal: String,
    @SerialName("BankAccount")
    val bankAccount: String,
    @SerialName("BankAccountHolderName")
    val bankAccountHolderName: String,
    @SerialName("BankId")
    val bankId: String,
    @SerialName("city")
    val city: String,
    @SerialName("color")
    val color: String,
    @SerialName("currency_ar")
    val currencyAr: String,
    @SerialName("currency_en")
    val currencyEn: String,
    @SerialName("delivery_days")
    val deliveryDays: String,
    @SerialName("delivery_period")
    val deliveryPeriod: String,
    @SerialName("demo_type")
    val demoType: String,
    @SerialName("email")
    val email: String,
    @SerialName("external_delivery_price")
    val externalDeliveryPrice: String,
    @SerialName("facebook")
    val facebook: String,
    @SerialName("favicon")
    val favicon: String,
    @SerialName("font_color")
    val fontColor: String,
    @SerialName("Iban")
    val iban: String,
    @SerialName("instagram")
    val instagram: String,
    @SerialName("internal_delivery_price")
    val internalDeliveryPrice: String,
    @SerialName("ios")
    val ios: String,
    @SerialName("is_demo")
    val isDemo: String,
    @SerialName("logo")
    val logo: String,
    @SerialName("min_order_cost")
    val minOrderCost: String,
    @SerialName("mobile")
    val mobile: String,
    @SerialName("name_ar")
    val nameAr: String,
    @SerialName("name_en")
    val nameEn: String,
    @SerialName("owner_name")
    val ownerName: String,
    @SerialName("period_allowed_reshipment_days")
    val periodAllowedReshipmentDays: String,
    @SerialName("reshipment_cost")
    val reshipmentCost: String,
    @SerialName("sec_color")
    val secColor: String,
    @SerialName("shipment_cost")
    val shipmentCost: String,
    @SerialName("snapchat")
    val snapchat: String,
    @SerialName("stock_ready")
    val stockReady: String,
    @SerialName("stock_type")
    val stockType: String,
    @SerialName("store_address")
    val storeAddress: String,
    @SerialName("store_name")
    val storeName: String,
    @SerialName("SupplierCode")
    val supplierCode: String,
    @SerialName("tax")
    val tax: String,
    @SerialName("tax_certificate_number")
    val taxCertificateNumber: String,
    @SerialName("tax_number")
    val taxNumber: String,
    @SerialName("tiktok")
    val tiktok: String,
    @SerialName("trade_name")
    val tradeName: String,
    @SerialName("twitter")
    val twitter: String,
    @SerialName("update_android")
    val updateAndroid: String,
    @SerialName("update_ios")
    val updateIos: String,
    @SerialName("whatsapp")
    val whatsapp: String,
    @SerialName("work_type")
    val workType: String
)