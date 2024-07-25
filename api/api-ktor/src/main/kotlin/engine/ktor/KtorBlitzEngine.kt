@file:OptIn(UnstableApi::class)

package engine.ktor

import annotation.UnstableApi
import engine.BlitzRequestsEngine
import engine.ktor.exception.getException
import engine.ktor.requests.accounts.AccountsEngine
import engine.ktor.response.ServerResponse
import engine.requests.AchievementsPlayersRequest
import engine.requests.BlitzRequest
import engine.requests.ListPlayersRequest
import engine.requests.StatisticsPlayersRequest
import exception.BlitzException
import exception.BlitzInternalException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import url.Url

public class KtorBlitzEngine(
    private val baseUrl: Url,
    httpClient: HttpClient = HttpClient(),
    json: Json = Json,
) : BlitzRequestsEngine {

    private val json = Json(json) {
        ignoreUnknownKeys = true
    }

    private val httpClient = httpClient.config {
        expectSuccess = true
        install(ContentNegotiation) {
            json(json)
        }
        defaultRequest {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }

    private val accounts = AccountsEngine(
        baseUrl = baseUrl,
        httpClient = this.httpClient
    )

    @Suppress("UNCHECKED_CAST")
    override suspend fun <T> execute(request: BlitzRequest<T>): T = handleBlitzExceptions {
        return when (request) {
            is ListPlayersRequest -> accounts.getListPlayers(request) as T
            is StatisticsPlayersRequest -> accounts.getStatisticsPlayers(request) as T
            is AchievementsPlayersRequest -> accounts.getAchievementsPlayers(request) as T
        }
    }

    private suspend inline fun <T> handleBlitzExceptions(block: () -> T): T {
        return try {
            block()
        } catch (exception: ResponseException) {
            val response = try {
                json.decodeFromString<ServerResponse<Nothing>>(exception.response.body()) as ServerResponse.Error
            } catch (exception: Throwable) {
                throw BlitzInternalException(cause = exception)
            }
            throw getException(response)
        } catch (exception: BlitzException) {
            throw exception
        } catch (exception: RuntimeException) {
            throw BlitzInternalException(cause = exception)
        }
    }

    private fun notSupported(): Nothing = TODO("This request is not supported yet!")
}
