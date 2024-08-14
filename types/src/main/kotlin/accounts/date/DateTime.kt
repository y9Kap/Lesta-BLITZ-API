package accounts.date

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

public data class DateTime(public val unixSeconds: Long) {
    public fun toLocalDateTime(timeZone: TimeZone = TimeZone.UTC): LocalDateTime {
        val instant = Instant.fromEpochSeconds(unixSeconds)
        return instant.toLocalDateTime(timeZone)
    }
}
