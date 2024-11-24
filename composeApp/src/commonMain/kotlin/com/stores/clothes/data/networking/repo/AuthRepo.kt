package com.stores.clothes.data.networking.repo

import com.stores.clothes.data.model.auth.requests.LoginRequest
import com.stores.clothes.data.model.auth.requests.ResendVerifyCodeRequest
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
import io.ktor.client.utils.EmptyContent.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.http.headers


class AuthRepo (private val httpClient: HttpClient){

    suspend fun login(mBody: LoginRequest) : Result<UserResponse, NetworkingError>{
        val response = try{
            httpClient.post (EndPoints.GET_BASE_URL+ EndPoints.EP_LOGIN){
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

    suspend fun verify(mBody: VerifyRequest): Result<UserResponse, NetworkingError> {
        val response = try{
            httpClient.post(EndPoints.GET_BASE_URL+ EndPoints.EP_VERIFY){
                setBody(FormDataContent(Parameters.build {
                    append("mobile", mBody.mobile)
                    append("code", mBody.code)
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

    suspend fun resendCode(mBody: ResendVerifyCodeRequest): Result<UserResponse, NetworkingError> {
        val response = try{
            httpClient.post(EndPoints.GET_BASE_URL+ EndPoints.EP_RESEND){
                setBody(FormDataContent(Parameters.build {
                    append("mobile", mBody.mobile)
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

}