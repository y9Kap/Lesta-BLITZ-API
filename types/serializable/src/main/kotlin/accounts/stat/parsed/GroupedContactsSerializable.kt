package accounts.stat.parsed

import auth.AccountIdSerializable
import auth.type
import kotlinx.serialization.Serializable

@Serializable
public data class GroupedContactsSerializable(
    val ungrouped: List<AccountIdSerializable>,
    val groups: Map<String, String>,
    val blocked: List<AccountIdSerializable>
)

public fun GroupedContactsSerializable.type(): GroupedContacts = GroupedContacts(
    ungrouped = ungrouped.map { it.type() },
    groups = groups,
    blocked = blocked.map { it.type() }
)
