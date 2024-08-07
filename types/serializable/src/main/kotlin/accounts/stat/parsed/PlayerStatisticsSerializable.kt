package accounts.stat.parsed

import accounts.date.DateTimeSerializable
import accounts.date.type
import auth.AccountIdSerializable
import auth.type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PlayerStatisticsSerializable(
    val statistics: StatisticsSerializable,
    @SerialName("account_id")
    val accountId: AccountIdSerializable,
    @SerialName("created_at")
    val createdAt: DateTimeSerializable,
    @SerialName("updated_at")
    val updatedAt: DateTimeSerializable,
    val private: PrivateSerializable? = null,
    @SerialName("last_battle_time")
    val lastBattleTime: DateTimeSerializable,
    val nickname: String
)

public fun PlayerStatisticsSerializable.type(): PlayerStatistics = PlayerStatistics(
    statistics = statistics.type(),
    accountId = accountId.type(),
    createdAt = createdAt.type(),
    updatedAt = updatedAt.type(),
    private = private?.type(),
    lastBattleTime = lastBattleTime.type(),
    nickname = nickname
)
