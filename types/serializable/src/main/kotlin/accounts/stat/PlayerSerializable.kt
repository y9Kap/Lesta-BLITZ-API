package accounts.stat

import auth.AccountIdSerializable
import auth.type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PlayerSerializable(
    @SerialName("account_id")
    val accountId: AccountIdSerializable,
    val nickname: String
)

public fun PlayerSerializable.type(): Player = Player(
    accountId.type(),
    nickname
)
