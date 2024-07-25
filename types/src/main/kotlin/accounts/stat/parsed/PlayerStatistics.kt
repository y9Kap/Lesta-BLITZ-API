package accounts.stat.parsed

import accounts.date.DateTime
import auth.AccountId

public data class PlayerStatistics(
    val statistics: Statistics,
    val accountId: AccountId,
    val createdAt: DateTime,
    val updatedAt: DateTime,
    val private: Private?,
    val lastBattleTime: DateTime,
    val nickname: String
)
