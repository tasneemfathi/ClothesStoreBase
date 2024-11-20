package com.stores.clothes.data.networking.utils

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> result(response: HttpResponse) =
    when (response.status.value) {
        in 200..299 -> Result.Success(response.body<T>())
        401 -> Result.Failure(NetworkingError.UNAUTHORIZED)
        409 -> Result.Failure(NetworkingError.CONFLICT)
        408 -> Result.Failure(NetworkingError.REQUEST_TIMEOUT)
        413 -> Result.Failure(NetworkingError.PAYLOAD_TOO_LARGE)
        in 500..599 -> Result.Failure(NetworkingError.SERVER_ERROR)
        else -> Result.Failure(NetworkingError.UNKNOWN)
    }