package com.stores.clothes.data.networking.client

import com.stores.clothes.data.datastore.AuthLocaleRepo
import com.stores.clothes.utils.log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.api.Send
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(localeStorage: AuthLocaleRepo): HttpClient {
    return HttpClient(createPlatformHttpClient()) {
        defaultRequest {
            headers.append("language", "ar")
            contentType(ContentType.Application.FormUrlEncoded)

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
                isLenient = true
            })
        }
        install(Auth) {
            bearer {
                loadTokens {
                    if(localeStorage.accessToken()  != null) {
                        BearerTokens(
                            accessToken = localeStorage.accessToken() ?: "",
                            refreshToken = null
                        )
                    }else{
                        null
                    }
                }
            }
        }
        install(createClientPlugin("fix") {
            on(Send) { request ->
                request.headers.remove("Accept-Charset")
                this.proceed(request)
            }
        })

    }

}