package accounts

import BlitzApi
import accounts.stat.Player
import auth.ApplicationId
import engine.requests.ListPlayersRequest

public class AccountsApi(private val api: BlitzApi) {

    public suspend fun listPlayers(
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

}
