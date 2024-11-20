package com.stores.clothes.data.networking.client

import com.stores.clothes.utils.log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(localeStorage: TokenLocaleStorage): HttpClient {
    return HttpClient(createPlatformHttpClient()) {
        defaultRequest {
            headers.append("language", "ar")
            headers.append("Accept", "application/json")
            headers.append("Content-Type", "application/x-www-form-urlencoded")
        }
        install(Logging){
            logger = object : Logger {
                override fun log(message: String) {
                   log(msg = message)
                }
            }
            this.level = LogLevel.ALL
        }
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
//        install(Auth) {
//            bearer {
//                loadTokens {
//                    if(localeStorage.accessToken()  != null) {
//                        BearerTokens(
//                            accessToken = localeStorage.accessToken() ?: "",
//                            refreshToken = null
//                        )
//                    }else{
//                        null
//                    }
//                }
//            }
//        }

    }

}