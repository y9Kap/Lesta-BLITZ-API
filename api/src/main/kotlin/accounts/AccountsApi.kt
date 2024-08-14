package accounts

import BlitzApi
import accounts.stat.parsed.Player
import accounts.stat.parsed.PlayerStatistics
import auth.AccessToken
import auth.AccountId
import auth.ApplicationId
import engine.requests.ListPlayersRequest
import engine.requests.StatisticsPlayersRequest

public class AccountsApi(private val api: BlitzApi) {

    public suspend fun getListPlayers(
        applicationId: ApplicationId,
        prompt: List<String>,
        fields: List<String>? = null,
        language: LocalLanguage? = null,
        limit: Int? = null,
        searchType: SearchType? = null
    ): List<Player> {
        return api.engine.execute(
            ListPlayersRequest(
                applicationId,
                prompt,
                fields,
                language,
                limit,
                searchType
            )
        ).players
    }

    public suspend fun getStatisticsPlayers(
        applicationId: ApplicationId,
        accountIds: List<AccountId>,
        accessToken: AccessToken? = null,
        extra: List<String>? = null,
        fields: List<String>? = null,
        language: LocalLanguage? = null
    ): Map<AccountId, PlayerStatistics> {
        return api.engine.execute(
            StatisticsPlayersRequest(
                applicationId,
                accountIds,
                accessToken,
                extra,
                fields,
                language
            )
        ).playerStatistics
    }

}
