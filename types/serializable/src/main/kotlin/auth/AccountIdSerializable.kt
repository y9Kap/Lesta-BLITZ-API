package auth

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class AccountIdSerializable(public val int: Int)

public fun AccountIdSerializable.type(): AccountId = AccountId(int)
public fun AccountId.serializable(): AccountIdSerializable = AccountIdSerializable(int)
