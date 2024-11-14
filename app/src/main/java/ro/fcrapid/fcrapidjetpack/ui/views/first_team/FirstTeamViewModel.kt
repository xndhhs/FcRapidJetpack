package ro.fcrapid.fcrapidjetpack.ui.views.first_team

import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.models.StaffModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.*
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.ATACANTI
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.FUNDASI
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.MIJLOCASI
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.PORTARI

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
            staffList = createStaffMap(),
            selectedTab = 0,
            tabHeaders = listOf(TabHeaders.JUCATORI, TabHeaders.STAFF)
        )
    }

    private fun createStaffMap(): Map<StaffRoles, List<StaffModel>> {
        return mapOf(
            StaffRoles.ANTRENOR_PRINCIPAL to
                    listOf(
                        StaffModel(
                            "Marius Sumudica",
                            "Antrenor Principal",
                            "25/06/1923",
                            R.drawable.staff_image
                        )
                    ),
            StaffRoles.ANTRENORI_SECUNZI to
                    listOf(
                        StaffModel(
                            "Cristian Petre",
                            "Antrenor Secund",
                            "25/06/1923",
                            R.drawable.staff_image1
                        ),
                        StaffModel(
                            "Gabriel Margarit",
                            "Antrenor Secund",
                            "25/06/1923",
                            R.drawable.staff_image2
                        ),
                        StaffModel(
                            "Sener Gencturk",
                            "Antrenor Secund",
                            "25/06/1923",
                            R.drawable.staff_image3
                        ),
                        StaffModel(
                            "Dumitru Hotoboc",
                            "Antrenor Portari",
                            "25/06/1923",
                            R.drawable.staff_image4
                        ),
                        StaffModel(
                            "Marius Stefan Sumudica Jr",
                            "Analist Video",
                            "25/06/1923",
                            R.drawable.staff_image16
                        ),
                    ),
            StaffRoles.STAFF_MEDICAL to
                    listOf(
                        StaffModel(
                            "Ciprian Moscu",
                            "Preparator Fizic",
                            "25/06/1923",
                            R.drawable.staff_image5
                        ),
                        StaffModel(
                            "Roberto Berruero",
                            "Preparator Fizic",
                            "25/06/1923",
                            R.drawable.staff_image6
                        ),
                        StaffModel(
                            "Andrei Curaliuc",
                            "Medic",
                            "25/06/1923",
                            R.drawable.staff_image7
                        ),
                        StaffModel(
                            "Senol Omer",
                            "Medic",
                            "25/06/1923",
                            R.drawable.staff_image8
                        ),
                        StaffModel(
                            "Adrian Mitea",
                            "Kinetoterapeut",
                            "25/06/1923",
                            R.drawable.staff_image17
                        ),
                        StaffModel(
                            "Dan Borcea",
                            "Kinetoterapeut",
                            "25/06/1923",
                            R.drawable.staff_image11
                        ),
                        StaffModel(
                            "Florin Dragne",
                            "Kinetoterapeut",
                            "25/06/1923",
                            R.drawable.staff_image12
                        ),
                        StaffModel(
                            "Marian Ionica",
                            "Maseur",
                            "25/06/1923",
                            R.drawable.staff_image13
                        )
                    ),
            StaffRoles.STAFF_ADMINISTRATIV to
                    listOf(
                        StaffModel(
                            "Ionut Voicu",
                            "Delegat",
                            "25/06/1923",
                            R.drawable.staff_image9
                        ),
                        StaffModel(
                            "Florentin Ion",
                            "Team Manager",
                            "25/06/1923",
                            R.drawable.staff_image10
                        ),
                        StaffModel(
                            "Cornel Mateiasi",
                            "Kit Manager",
                            "25/06/1923",
                            R.drawable.staff_image14
                        ),
                        StaffModel(
                            "Adrian Tarchila",
                            "Magazioner",
                            "25/06/1923",
                            R.drawable.staff_image15
                        )
                    ),
            )
    }

    override fun handleEvents(event: Event) {
        when (event) {
            Event.OnPlayerDetails -> {}
            Event.OnStaffDetails -> {}
            is Event.OnHeaderTabSelected -> {
                setState { copy(selectedTab = tabHeaders.indexOf(event.tabHeader)) }
            }

        }
    }
}