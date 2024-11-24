package com.stores.clothes.data.networking.repo

import com.stores.clothes.data.model.auth.requests.LoginRequest
import com.stores.clothes.data.model.auth.requests.VerifyRequest
import com.stores.clothes.data.model.auth.response.UserResponse
import com.stores.clothes.data.model.config.config.ConfigResponse
import com.stores.clothes.data.model.config.countries.CountriesResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import com.stores.clothes.data.networking.utils.NetworkingError
import com.stores.clothes.data.networking.utils.Result
import com.stores.clothes.data.networking.utils.EndPoints
import com.stores.clothes.data.networking.utils.result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.request.accept
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import io.ktor.http.contentType


class ConfigRepo (private val httpClient: HttpClient){

    suspend fun getConfig() : Result<ConfigResponse, NetworkingError>{
        val response = try{
            httpClient.get (EndPoints.GET_BASE_URL+ EndPoints.EP_CONFIG)
        } catch(e: UnresolvedAddressException) {
            e.printStackTrace()
            return Result.Failure(NetworkingError.NO_INTERNET)
        } catch(e: SerializationException) {
            e.printStackTrace()
            return Result.Failure(NetworkingError.SERIALIZATION)
        } catch(e: ConnectTimeoutException) {
            e.printStackTrace()
            return Result.Failure(NetworkingError.REQUEST_TIMEOUT)
        }
        return result<ConfigResponse>(response)
    }

    suspend fun getCountries(): Result<CountriesResponse, NetworkingError> {
        val response = try{
            httpClient.get(EndPoints.GET_BASE_URL+EndPoints.EP_COUNTRIES)
        } catch(e: UnresolvedAddressException) {
            e.printStackTrace()
            return Result.Failure(NetworkingError.NO_INTERNET)
        } catch(e: SerializationException) {
            e.printStackTrace()
            return Result.Failure(NetworkingError.SERIALIZATION)
        } catch(e: ConnectTimeoutException) {
            e.printStackTrace()
            return Result.Failure(NetworkingError.REQUEST_TIMEOUT)
        }
        return result<CountriesResponse>(response)
    }

}