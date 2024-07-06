package accounts

import accounts.date.DateTime
import accounts.stat.Private
import accounts.stat.Statistics
import auth.AccountId

public data class FullUser(
    val statistics: Statistics,
    val accountId: AccountId,
    val createdAt: DateTime,
    val updatedAt: DateTime,
    val private: Private?,
    val lastBattleTime: DateTime,
    val nickname: String
)
