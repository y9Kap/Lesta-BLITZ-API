package accounts.stat

import auth.AccountId

public data class GroupedContacts(
    val ungrouped: List<AccountId>,
    val groups: Map<String, String>,
    val blocked: List<AccountId>
)
