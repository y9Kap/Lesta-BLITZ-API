package accounts.stat

import accounts.date.DateTimeSerializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RestrictionsSerializable(
    @SerialName("chat_ban_time")
    val chatBanTime: DateTimeSerializable
)
