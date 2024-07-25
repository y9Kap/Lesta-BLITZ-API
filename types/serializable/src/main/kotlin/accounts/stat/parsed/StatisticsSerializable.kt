package accounts.stat.parsed

import kotlinx.serialization.Serializable

@Serializable
public data class StatisticsSerializable(
    val clan: AnalyticsSerializable,
    val all: AnalyticsSerializable,
    val frags: Map<String, Int>? = null,
    val rating: RatingSerializable? = null
)

public fun StatisticsSerializable.type(): Statistics = Statistics(
    clan = clan.type(),
    all = all.type(),
    frags = frags,
    rating = rating?.type()
)
