package ro.fcrapid.fcrapidjetpack.models

data class TeamModel(
    val teamName: String,
    val teamPosition: String,
    val matchesPlayed: String,
    val matchesWon: String,
    val matchesDrew: String,
    val matchesLost: String,
    val goalDifferential: String,
    val points: String,
    val teamIcon: String? = null
)
