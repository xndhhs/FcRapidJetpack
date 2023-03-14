package ro.fcrapid.fcrapidjetpack.models

import java.util.*

data class PlayerModel(
    val playerName: String,
    val playerPosition: String,
    val playerAge: Int,
    val playerShirtNumber: String,
    val playerBirthDate: Date?,
    val playerMatches: Int,
    val playerGoals: Int,
    val playerMatchesCurrentSeason: Int,
    val playerGoalsCurrentSeason: Int,
    val playerIcon: Int
) {

}