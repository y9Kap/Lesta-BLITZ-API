package accounts.stat

import auth.AccountIdSerializable
import kotlinx.serialization.Serializable

@Serializable
public data class GroupedContactsSerializable(
    val ungrouped: List<AccountIdSerializable>,
    val groups: Map<String, String>,
    val blocked: List<AccountIdSerializable>
)
