import accounts.AccountsApi
import engine.BlitzRequestsEngine

public class BlitzApi(
    public val engine: BlitzRequestsEngine
) {
    public val accounts: AccountsApi = AccountsApi(api = this)
    public companion object
}
