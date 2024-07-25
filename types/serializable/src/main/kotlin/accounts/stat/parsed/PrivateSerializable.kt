package accounts.stat.parsed

import accounts.date.DateTimeSerializable
import accounts.date.type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PrivateSerializable(
    val restrictions: RestrictionsSerializable,
    @SerialName("grouped_contacts")
    val groupedContacts: GroupedContactsSerializable,
    val gold: Int,
    @SerialName("free_xp")
    val freeXp: Int,
    @SerialName("ban_time")
    val banTime: DateTimeSerializable? = null,
    @SerialName("is_premium")
    val isPremium: Boolean,
    val credits: Long,
    @SerialName("premium_expires_at")
    val premiumExpiresAt: DateTimeSerializable,
    @SerialName("battle_life_time")
    val battleLifeTimeInSeconds: Long,
    @SerialName("ban_info")
    val banInfo: String
)

public fun PrivateSerializable.type(): Private = Private(
    restrictions = restrictions.type(),
    groupedContacts = groupedContacts.type(),
    gold = gold,
    freeXp = freeXp,
    banTime = banTime?.type(),
    isPremium = isPremium,
    credits = credits,
    premiumExpiresAt = premiumExpiresAt.type(),
    battleLifeTimeInSeconds = battleLifeTimeInSeconds,
    banInfo = banInfo
)
