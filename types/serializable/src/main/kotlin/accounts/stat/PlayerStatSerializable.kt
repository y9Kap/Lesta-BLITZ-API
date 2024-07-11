package accounts.stat

import accounts.date.DateTimeSerializable
import auth.AccountIdSerializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PlayerStatSerializable(
    val statistics: StatisticsSerializable,
    @SerialName("account_id")
    val accountId: AccountIdSerializable,
    @SerialName("created_at")
    val createdAt: DateTimeSerializable,
    @SerialName("updated_at")
    val updatedAt: DateTimeSerializable,
    val private: PrivateSerializable?,
    @SerialName("last_battle_time")
    val lastBattleTime: DateTimeSerializable,
    val nickname: String
)
