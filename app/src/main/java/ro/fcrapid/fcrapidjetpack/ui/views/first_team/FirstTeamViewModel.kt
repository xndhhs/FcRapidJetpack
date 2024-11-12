package ro.fcrapid.fcrapidjetpack.ui.views.first_team

import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.Effect
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.Event
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.ATACANTI
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.FUNDASI
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.MIJLOCASI
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.PORTARI
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.State

class FirstTeamViewModel(
    savedStateHandle: SavedStateHandle,
    appBackgroundEventHandler: AppBackgroundEventHandler
) : BaseViewModel<Event, State, Effect>(savedStateHandle, appBackgroundEventHandler) {


    override fun setInitialState(): State {
        return State(
            playersList = mapOf(
                PORTARI to
                listOf(
                PlayerModel(
                    playerName = "Codrut Sandu",
                    playerPosition = "Portar",
                    playerAge = 19,
                    playerShirtNumber = "1",
                    playerBirthDate = null,
                    playerMatches = 0,
                    playerGoals = 0,
                    playerMatchesCurrentSeason = 0,
                    playerGoalsCurrentSeason = 0,
                    playerIcon = R.drawable.player_1_sandu
                ),
                PlayerModel(
                    playerName = "Junior Morais",
                    playerPosition = "Fundas",
                    playerAge = 36,
                    playerShirtNumber = "13",
                    playerBirthDate = null,
                    playerMatches = 0,
                    playerGoals = 0,
                    playerMatchesCurrentSeason = 0,
                    playerGoalsCurrentSeason = 0,
                    playerIcon = R.drawable.player_13_morais
                ),
                PlayerModel(
                    playerName = "Horatiu Moldovan",
                    playerPosition = "Portar",
                    playerAge = 25,
                    playerShirtNumber = "31",
                    playerBirthDate = null,
                    playerMatches = 0,
                    playerGoals = 0,
                    playerMatchesCurrentSeason = 0,
                    playerGoalsCurrentSeason = 0,
                    playerIcon = R.drawable.player_31_moldovan
                ),
                PlayerModel(
                    playerName = "Florin Stefan",
                    playerPosition = "Fundas",
                    playerAge = 19,
                    playerShirtNumber = "3",
                    playerBirthDate = null,
                    playerMatches = 0,
                    playerGoals = 0,
                    playerMatchesCurrentSeason = 0,
                    playerGoalsCurrentSeason = 0,
                    playerIcon = R.drawable.player_3_stefan
                ),
                PlayerModel(
                    playerName = "Ljuban Crepulja",
                    playerPosition = "Mijlocas",
                    playerAge = 19,
                    playerShirtNumber = "4",
                    playerBirthDate = null,
                    playerMatches = 0,
                    playerGoals = 0,
                    playerMatchesCurrentSeason = 0,
                    playerGoalsCurrentSeason = 0,
                    playerIcon = R.drawable.player_4_crepulja
                )
                ),
                FUNDASI to
                        listOf(
                            PlayerModel(
                                playerName = "Codrut Sandu",
                                playerPosition = "Portar",
                                playerAge = 19,
                                playerShirtNumber = "1",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_1_sandu
                            ),
                            PlayerModel(
                                playerName = "Junior Morais",
                                playerPosition = "Fundas",
                                playerAge = 36,
                                playerShirtNumber = "13",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_13_morais
                            ),
                            PlayerModel(
                                playerName = "Horatiu Moldovan",
                                playerPosition = "Portar",
                                playerAge = 25,
                                playerShirtNumber = "31",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_31_moldovan
                            ),
                            PlayerModel(
                                playerName = "Florin Stefan",
                                playerPosition = "Fundas",
                                playerAge = 19,
                                playerShirtNumber = "3",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_3_stefan
                            ),
                            PlayerModel(
                                playerName = "Ljuban Crepulja",
                                playerPosition = "Mijlocas",
                                playerAge = 19,
                                playerShirtNumber = "4",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_4_crepulja
                            )
                        ),
                MIJLOCASI to
                        listOf(
                            PlayerModel(
                                playerName = "Codrut Sandu",
                                playerPosition = "Portar",
                                playerAge = 19,
                                playerShirtNumber = "1",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_1_sandu
                            ),
                            PlayerModel(
                                playerName = "Junior Morais",
                                playerPosition = "Fundas",
                                playerAge = 36,
                                playerShirtNumber = "13",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_13_morais
                            ),
                            PlayerModel(
                                playerName = "Horatiu Moldovan",
                                playerPosition = "Portar",
                                playerAge = 25,
                                playerShirtNumber = "31",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_31_moldovan
                            ),
                            PlayerModel(
                                playerName = "Florin Stefan",
                                playerPosition = "Fundas",
                                playerAge = 19,
                                playerShirtNumber = "3",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_3_stefan
                            ),
                            PlayerModel(
                                playerName = "Ljuban Crepulja",
                                playerPosition = "Mijlocas",
                                playerAge = 19,
                                playerShirtNumber = "4",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_4_crepulja
                            )
                        ),
                ATACANTI to
                        listOf(
                            PlayerModel(
                                playerName = "Codrut Sandu",
                                playerPosition = "Portar",
                                playerAge = 19,
                                playerShirtNumber = "1",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_1_sandu
                            ),
                            PlayerModel(
                                playerName = "Junior Morais",
                                playerPosition = "Fundas",
                                playerAge = 36,
                                playerShirtNumber = "13",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_13_morais
                            ),
                            PlayerModel(
                                playerName = "Horatiu Moldovan",
                                playerPosition = "Portar",
                                playerAge = 25,
                                playerShirtNumber = "31",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_31_moldovan
                            ),
                            PlayerModel(
                                playerName = "Florin Stefan",
                                playerPosition = "Fundas",
                                playerAge = 19,
                                playerShirtNumber = "3",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_3_stefan
                            ),
                            PlayerModel(
                                playerName = "Ljuban Crepulja",
                                playerPosition = "Mijlocas",
                                playerAge = 19,
                                playerShirtNumber = "4",
                                playerBirthDate = null,
                                playerMatches = 0,
                                playerGoals = 0,
                                playerMatchesCurrentSeason = 0,
                                playerGoalsCurrentSeason = 0,
                                playerIcon = R.drawable.player_4_crepulja
                            )
                        )
            ),
            staffList = listOf(),
            selectedTab = 0
        )
    }

    override fun handleEvents(event: Event) {
        when (event) {
            Event.OnPlayerDetails -> {}
            Event.OnStaffDetails -> {}
        }
    }
}