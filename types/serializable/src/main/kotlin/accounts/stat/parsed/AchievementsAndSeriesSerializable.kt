package accounts.stat.parsed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AchievementsAndSeriesSerializable(
    val achievements: Map<String, Long>,
    @SerialName("max_series")
    val maxSeries: Map<String, Long>
)

public fun AchievementsAndSeriesSerializable.type(): AchievementsAndSeries = AchievementsAndSeries(
    achievements = achievements,
    maxSeries = maxSeries
)
