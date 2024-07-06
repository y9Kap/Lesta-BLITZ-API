package accounts.date

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class DateTimeSerializable(public val unixSeconds: Long)

public fun DateTimeSerializable.type(): DateTime = DateTime(unixSeconds)
public fun DateTime.serializable(): DateTimeSerializable = DateTimeSerializable(unixSeconds)
