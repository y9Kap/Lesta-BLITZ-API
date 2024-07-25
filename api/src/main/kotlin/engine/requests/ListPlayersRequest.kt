package engine.requests

import accounts.LocalLanguage
import accounts.SearchType
import accounts.stat.parsed.Player
import auth.ApplicationId

public data class ListPlayersRequest(
    public val applicationId: ApplicationId,
    public val prompt: List<String>,
    public val fields: List<String>?,
    public val language: LocalLanguage?,
    public val limit: Int?,
    public val searchType: SearchType?
) : BlitzRequest<ListPlayersRequest.Response> {
    public data class Response(val players: List<Player>)
}
