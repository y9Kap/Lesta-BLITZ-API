package accounts.stat

import kotlinx.serialization.Serializable

@Serializable
public data class StatisticsSerializable(
    val clan: Analytics,
    val all: Analytics,
    val frags: Map<String, Int>?,
    val rating: RatingSerializable?
)
