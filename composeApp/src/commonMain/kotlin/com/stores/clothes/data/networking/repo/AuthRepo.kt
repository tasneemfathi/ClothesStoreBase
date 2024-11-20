package com.stores.clothes.data.networking.repo

import com.stores.clothes.data.model.auth.requests.LoginRequest
import com.stores.clothes.data.model.auth.requests.VerifyRequest
import com.stores.clothes.data.model.auth.response.UserResponse
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
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import io.ktor.http.contentType


class AuthRepo (private val httpClient: HttpClient){

    suspend fun login(mBody: LoginRequest) : Result<UserResponse, NetworkingError>{
        val response = try{
            httpClient.post (EndPoints.GET_BASE_URL+ EndPoints.EP_LOGIN){
                method = HttpMethod.Post
                contentType(ContentType.Application.FormUrlEncoded)
                accept(ContentType.Application.Json)
                setBody(FormDataContent(Parameters.build {
                    append("mobile", mBody.mobile)
                    append("name", mBody.name)
                    append("country_id", mBody.countryId)
                }))

            }
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
        return result<UserResponse>(response)
    }

    suspend fun verify(body: VerifyRequest): Result<UserResponse, NetworkingError> {
        val response = try{
            httpClient.request{
                method = HttpMethod.Post
                url(EndPoints.GET_BASE_URL+ EndPoints.EP_VERIFY)
                setBody(body)
            }
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
        return result<UserResponse>(response)
    }

    suspend fun resendCode(body: VerifyRequest): Result<UserResponse, NetworkingError> {
        val response = try{
            httpClient.request{
                HttpMethod.Post
                url(EndPoints.GET_BASE_URL+ EndPoints.EP_RESEND)
                setBody(body)
            }
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
        return result<UserResponse>(response)
    }

}