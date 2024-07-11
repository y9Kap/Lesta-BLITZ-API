package accounts.stat

import accounts.date.DateTime
import auth.AccountId

public data class PlayerStat(
    val statistics: Statistics,
    val accountId: AccountId,
    val createdAt: DateTime,
    val updatedAt: DateTime,
    val private: Private?,
    val lastBattleTime: DateTime,
    val nickname: String
)
