package ro.fcrapid.fcrapidjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.ui.FirstTeamScreen
import ro.fcrapid.fcrapidjetpack.ui.contact.ContactDetailsScreen
import ro.fcrapid.fcrapidjetpack.ui.history.ClubHistoryScreen
import ro.fcrapid.fcrapidjetpack.ui.theme.FcRapidJetpackTheme

class MainActivity : ComponentActivity() {
    private var playerList: List<PlayerModel> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            FcRapidJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    createPlayerList()
//                    FirstTeamScreen(playerList)
//                    ContactDetailsScreen()
                    ClubHistoryScreen()
                }
            }
        }
    }


    private fun createPlayerList() {
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
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FcRapidJetpackTheme {
        Greeting("Android")
    }
}