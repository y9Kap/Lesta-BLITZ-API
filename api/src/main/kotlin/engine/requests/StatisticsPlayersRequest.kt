package engine.requests

import accounts.LocalLanguage
import accounts.stat.parsed.PlayerStatistics
import auth.AccessToken
import auth.AccountId
import auth.ApplicationId

public data class StatisticsPlayersRequest(
    public val applicationId: ApplicationId,
    public val accountIds: List<AccountId>,
    public val accessToken: AccessToken?,
    public val extra: List<String>?,
    public val fields: List<String>?,
    public val language: LocalLanguage?
) : BlitzRequest<StatisticsPlayersRequest.Response> {
    public data class Response(val playerStatistics: Map<AccountId, PlayerStatistics>)
}
