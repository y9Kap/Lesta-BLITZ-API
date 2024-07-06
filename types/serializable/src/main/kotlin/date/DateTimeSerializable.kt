package date

import accounts.date.DateTime
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class DateTimeSerializable(public val seconds: Long)

public fun DateTimeSerializable.type(): DateTime = DateTime(seconds)
