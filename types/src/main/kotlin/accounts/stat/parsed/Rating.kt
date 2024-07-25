package accounts.stat.parsed

import accounts.date.DateTime

public data class Rating(
    val spotted: Long,
    val battlesLeftBeforeCalibration: Int,
    val hits: Long,
    val frags: Int,
    val recalibrationStartTime: DateTime,
    val balancerRating: Double,
    val wins: Int,
    val losses: Int,
    val isRecalibration: Boolean,
    val capturePoints: Int,
    val battleCount: Int,
    val currentSeason: Int,
    val damageDealt: Long,
    val damageReceived: Long,
    val shots: Long,
    val frags8p: Int,
    val xp: Long,
    val winAndSurvived: Int,
    val survivedBattles: Int,
    val defensePoints: Int
)
