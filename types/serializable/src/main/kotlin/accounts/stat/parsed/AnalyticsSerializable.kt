package accounts.stat.parsed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class AnalyticsSerializable(
    val spotted: Long,
    @SerialName("max_frags_tank_id")
    val maxFragsTankId: Int,
    val hits: Long,
    val frags: Int,
    @SerialName("max_xp")
    val maxXp: Int,
    @SerialName("max_xp_tank_id")
    val maxXpTankId: Int,
    val wins: Int,
    val losses: Int,
    @SerialName("capture_points")
    val capturePoints: Int,
    @SerialName("battles")
    val battleCount: Int,
    @SerialName("damage_dealt")
    val damageDealt: Long,
    @SerialName("damage_received")
    val damageReceived: Long,
    @SerialName("max_frags")
    val maxFrags: Int,
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

public fun AnalyticsSerializable.type(): Analytics = Analytics(
    spotted = spotted,
    maxFragsTankId = maxFragsTankId,
    hits = hits,
    frags = frags,
    maxXp = maxXp,
    maxXpTankId = maxXpTankId,
    wins = wins,
    losses = losses,
    capturePoints = capturePoints,
    battleCount = battleCount,
    damageDealt = damageDealt,
    damageReceived = damageReceived,
    maxFrags = maxFrags,
    shots = shots,
    frags8p = frags8p,
    xp = xp,
    winAndSurvived = winAndSurvived,
    survivedBattles = survivedBattles,
    defensePoints = defensePoints
)
