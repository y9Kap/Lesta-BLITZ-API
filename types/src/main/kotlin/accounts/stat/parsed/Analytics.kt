package accounts.stat.parsed

public data class Analytics(
    val spotted: Long,
    val maxFragsTankId: Int,
    val hits: Long,
    val frags: Int,
    val maxXp: Int,
    val maxXpTankId: Int,
    val wins: Int,
    val losses: Int,
    val capturePoints: Int,
    val battleCount: Int,
    val damageDealt: Long,
    val damageReceived: Long,
    val maxFrags: Int,
    val shots: Long,
    val frags8p: Int,
    val xp: Long,
    val winAndSurvived: Int,
    val survivedBattles: Int,
    val defensePoints: Int
)
