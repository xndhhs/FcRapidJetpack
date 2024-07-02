package ro.fcrapid.fcrapidjetpack.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.ui.first_team.TeamMemberView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstTeamScreen(playerList: List<PlayerModel>) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text(text = "Prima Echipa", style = MaterialTheme.typography.headlineSmall)
        MultiChoiceSegmentedButtonRow(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)) {
            SegmentedButton(
                checked = true, onCheckedChange = {}, shape = SegmentedButtonDefaults.itemShape(
                    index = 0,
                    count = 2
                ),
                colors = SegmentedButtonDefaults.colors(),
                label = { Text(text = "Jucatori") }
            )
            SegmentedButton(
                checked = false, onCheckedChange = {}, shape = SegmentedButtonDefaults.itemShape(
                    index = 1,
                    count = 2
                ),
                colors = SegmentedButtonDefaults.colors(),
                label = { Text(text = "Staff") }
            )
        }
        LazyColumn {
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
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FirstTeamScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        FirstTeamScreen(
            playerList = listOf(
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
        )
    }
}