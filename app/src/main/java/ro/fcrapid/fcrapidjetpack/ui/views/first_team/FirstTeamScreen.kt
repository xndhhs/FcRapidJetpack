package ro.fcrapid.fcrapidjetpack.ui.views.first_team

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.models.StaffModel
import ro.fcrapid.fcrapidjetpack.ui.theme.large
import ro.fcrapid.fcrapidjetpack.ui.theme.small
import ro.fcrapid.fcrapidjetpack.ui.theme.standard
import ro.fcrapid.fcrapidjetpack.ui.theme.xSmall
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.Event
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.Event.OnHeaderTabSelected
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.PlayerRoles.PORTARI
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.State
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.VerticalSpacer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstTeamScreen(
    viewState: androidx.compose.runtime.State<State>,
    onEventSent: (event: Event) -> Unit
) {
    val state = viewState.value
    Column(modifier = Modifier
        .padding(vertical = standard, horizontal = large)
        .fillMaxSize()) {
        PrimaryTabRow(
            selectedTabIndex = state.selectedTab,
            tabs = {
                state.tabHeaders.forEachIndexed { index, tabHeader ->
                    Tab(
                        modifier = Modifier.background(
                            MaterialTheme.colorScheme.background,
                            RectangleShape
                        ),
                        selected = state.selectedTab == index,
                        onClick = { onEventSent(OnHeaderTabSelected(tabHeader)) }
                    ) {
                        Text(text = tabHeader.label, modifier = Modifier.padding(small))
                    }
                }
            }
        )
        if (state.selectedTab == 0) {
            FirstTeamSection(state)
        } else {
            StaffSection(state)
        }
    }
}

@Composable
fun StaffSection(state: State) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        state.staffList.forEach { (key, value) ->
            StaffRoleSection(key.name, value)
        }
    }
}

@Composable
private fun FirstTeamSection(state: State) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        state.playersList.forEach { (key, value) ->
            PlayerRoleSection(key.name, value)
        }
    }
}

@Composable
private fun PlayerRoleSection(sectionName: String, playerList: List<PlayerModel>) {
    VerticalSpacer(height = standard)
    Text(
        text = sectionName,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.background,
        letterSpacing = MaterialTheme.typography.bodyLarge.letterSpacing,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(standard)
            )
            .padding(vertical = xSmall, horizontal = small)
    )
    VerticalSpacer(height = standard)
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(large),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        playerList.forEach {
            item {
                TeamMemberView(
                    it.playerName,
                    it.playerPosition,
                    it.playerShirtNumber,
                    it.playerIcon
                )
            }
        }
    }
}

@Composable
private fun StaffRoleSection(sectionName: String, staffList: List<StaffModel>) {
    VerticalSpacer(height = standard)
    Text(
        text = sectionName.replace("_", " "),
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.background,
        letterSpacing = MaterialTheme.typography.bodyLarge.letterSpacing,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(standard)
            )
            .padding(vertical = xSmall, horizontal = small)
    )
    VerticalSpacer(height = standard)
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(large),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        staffList.forEach {
            item {
                StaffMemberView(
                    it.name,
                    it.role,
                    it.birthDate,
                    it.image
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FirstTeamScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val viewState = remember {
            mutableStateOf(
                State(
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
                                )
                    ),
                    staffList = mapOf(),
                    selectedTab = 0,
                    tabHeaders = listOf()
                )
            )
        }
        FirstTeamScreen(viewState) {}
    }
}