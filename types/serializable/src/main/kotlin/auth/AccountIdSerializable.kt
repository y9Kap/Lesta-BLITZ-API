package auth

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class AccountIdSerializable(public val long: Long)

public fun AccountIdSerializable.type(): AccountId = AccountId(long)
public fun AccountId.serializable(): AccountIdSerializable = AccountIdSerializable(long)
