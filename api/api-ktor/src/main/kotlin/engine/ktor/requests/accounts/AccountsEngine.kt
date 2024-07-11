@file:OptIn(UnstableApi::class)

package engine.ktor.requests.accounts


import accounts.stat.PlayerSerializable
import accounts.stat.type
import annotation.UnstableApi
import engine.ktor.response.bodyAsSuccess
import engine.requests.ListPlayersRequest
import io.ktor.client.*
import io.ktor.client.request.*
import url.Url

internal class AccountsEngine(
    baseUrl: Url,
    private val httpClient: HttpClient
) {
    private val baseUrl =  baseUrl / "account"

    suspend fun listPlayers(request: ListPlayersRequest): ListPlayersRequest.Response {
        val url = baseUrl / "list"
        val response = httpClient.get(url.string) {
            parameter("application_id", request.applicationId.string)
            parameter("search", request.prompt.joinToString(","))
            parameter("fields", request.fields?.joinToString(","))
            parameter("language", request.language?.type)
            parameter("limit", request.limit)
            parameter("type", request.searchType?.type)
        }.bodyAsSuccess<List<PlayerSerializable>>()
        return ListPlayersRequest.Response(response.map { it.type() })
    }
}
