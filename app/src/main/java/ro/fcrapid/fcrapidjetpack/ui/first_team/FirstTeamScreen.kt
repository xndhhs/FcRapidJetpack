package ro.fcrapid.fcrapidjetpack.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.ui.first_team.PlayerItemView

@Composable
fun FirstTeamScreen(playerList: List<PlayerModel>) {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colorScheme.primary)) {
        playerList.forEach{
            item { PlayerItemView(it) }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FirstTeamScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.error
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