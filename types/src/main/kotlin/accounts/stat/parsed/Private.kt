package accounts.stat.parsed

import accounts.date.DateTime

public data class Private(
    val restrictions: Restrictions,
    val groupedContacts: GroupedContacts,
    val gold: Int,
    val freeXp: Int,
    val banTime: DateTime?,
    val isPremium: Boolean,
    val credits: Long,
    val premiumExpiresAt: DateTime,
    val battleLifeTimeInSeconds: Long,
    val banInfo: String
)
