package accounts.stat

import accounts.date.DateTimeSerializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RatingSerializable(
    val spotted: Long,
    @SerialName("calibration_battles_left")
    val battlesLeftBeforeCalibration: Int,
    val hits: Long,
    val frags: Int,
    @SerialName("recalibration_start_time")
    val recalibrationStartTime: DateTimeSerializable,
    @SerialName("mm_rating")
    val balancerRating: Double,
    val wins: Int,
    val losses: Int,
    @SerialName("is_recalibration")
    val isRecalibration: Boolean,
    @SerialName("capture_points")
    val capturePoints: Int,
    @SerialName("battles")
    val battleCount: Int,
    @SerialName("current_season")
    val currentSeason: Int,
    @SerialName("damage_dealt")
    val damageDealt: Long,
    @SerialName("damage_received")
    val damageReceived: Long,
    val shots: Long,
    val frags8p: Int,
    val xp: Long,
    @SerialName("win_and_survived")
    val winAndSurvived: Int,
    @SerialName("survived_battles")
    val survivedBattles: Int,
    @SerialName("dropped_capture_points")
    val defensePoints: Int
)
