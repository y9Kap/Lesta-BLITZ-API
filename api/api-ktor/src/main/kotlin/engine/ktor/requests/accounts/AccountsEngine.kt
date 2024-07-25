@file:OptIn(UnstableApi::class)

package engine.ktor.requests.accounts

import accounts.stat.parsed.AchievementsAndSeriesSerializable
import accounts.stat.parsed.PlayerSerializable
import accounts.stat.parsed.PlayerStatisticsSerializable
import accounts.stat.parsed.type
import annotation.UnstableApi
import auth.AccountIdSerializable
import auth.type
import engine.ktor.response.bodyAsSuccess
import engine.requests.AchievementsPlayersRequest
import engine.requests.ListPlayersRequest
import engine.requests.StatisticsPlayersRequest
import io.ktor.client.*
import io.ktor.client.request.*
import url.Url

internal class AccountsEngine(
    baseUrl: Url,
    private val httpClient: HttpClient
) {
    private val baseUrl =  baseUrl / "account"

    suspend fun getListPlayers(request: ListPlayersRequest): ListPlayersRequest.Response {
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

    suspend fun getStatisticsPlayers(request: StatisticsPlayersRequest): StatisticsPlayersRequest.Response {
        val url = baseUrl / "info"
        val response = httpClient.get(url.string) {
            parameter("application_id", request.applicationId.string)
            parameter("account_id", request.accountIds.map { it.long }.joinToString(","))
            parameter("access_token", request.accessToken?.string)
            parameter("extra", request.extra)
            parameter("fields", request.fields)
            parameter("language", request.language?.type)
        }.bodyAsSuccess<Map<AccountIdSerializable, PlayerStatisticsSerializable>>()
        return StatisticsPlayersRequest.Response(response.map {
            it.key.type() to it.value.type()
        }.toMap())
    }

    suspend fun getAchievementsPlayers(request: AchievementsPlayersRequest): AchievementsPlayersRequest.Response {
        val url = baseUrl / "achievements"
        val response = httpClient.get(url.string) {
            parameter("application_id", request.applicationId.string)
            parameter("account_id", request.accountIds.map { it.long }.joinToString(","))
            parameter("fields", request.fields)
            parameter("language", request.language?.type)
        }.bodyAsSuccess<Map<AccountIdSerializable, AchievementsAndSeriesSerializable>>()
        return  AchievementsPlayersRequest.Response(response.map {
            it.key.type() to it.value.type()
        }.toMap())
    }
}
