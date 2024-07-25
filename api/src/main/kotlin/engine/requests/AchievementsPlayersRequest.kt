package engine.requests

import accounts.LocalLanguage
import accounts.stat.parsed.AchievementsAndSeries
import auth.AccountId
import auth.ApplicationId

public data class AchievementsPlayersRequest(
    public val applicationId: ApplicationId,
    public val accountIds: List<AccountId>,
    public val fields: List<String>?,
    public val language: LocalLanguage?
) : BlitzRequest<AchievementsPlayersRequest.Response> {
    public data class Response(val playerStatistics: Map<AccountId, AchievementsAndSeries>)
}
