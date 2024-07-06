package accounts.stat

import accounts.date.DateTimeSerializable
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
    val banTime: DateTimeSerializable?,
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
