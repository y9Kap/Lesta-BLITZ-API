package accounts.stat.parsed

public data class AchievementsAndSeries(
    val achievements: Map<String, Long>,
    val maxSeries: Map<String, Long>
)
