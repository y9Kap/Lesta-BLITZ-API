package auth

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class AccessTokenSerializable(public val string: String)

public fun AccessTokenSerializable.type(): AccessToken = AccessToken(string)
public fun AccessToken.serializable(): AccessTokenSerializable = AccessTokenSerializable(string)
