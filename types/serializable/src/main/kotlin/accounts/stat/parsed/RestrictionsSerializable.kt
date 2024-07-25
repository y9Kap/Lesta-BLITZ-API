package accounts.stat.parsed

import accounts.date.DateTimeSerializable
import accounts.date.type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RestrictionsSerializable(
    @SerialName("chat_ban_time")
    val chatBanTime: DateTimeSerializable
)

public fun RestrictionsSerializable.type(): Restrictions = Restrictions(
    chatBanTime = chatBanTime.type()
)
