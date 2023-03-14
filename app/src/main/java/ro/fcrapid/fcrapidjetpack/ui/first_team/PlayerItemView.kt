package ro.fcrapid.fcrapidjetpack.ui.first_team

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.models.PlayerModel
import ro.fcrapid.fcrapidjetpack.ui.theme.rapid_font
import java.util.*


@Composable
fun PlayerItemView(playerModel: PlayerModel) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        shape = RoundedCornerShape(16.dp),

    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = CenterVertically
        ) {
            Row(modifier = Modifier
                .weight(0.8f)
                .fillMaxWidth()) {
                Card(
                    shape = RectangleShape,
                    modifier = Modifier
                        .width(70.dp)
                        .height(100.dp)
                        .background(MaterialTheme.colorScheme.background, RectangleShape),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                ) {
                    Image(
                        painter = painterResource(id = playerModel.playerIcon),
                        contentDescription = playerModel.playerName
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column() {
                    Row(verticalAlignment = Alignment.Top) {
                        Text(text = "Nume: ", style = MaterialTheme.typography.labelSmall)
                        Text(
                            text = playerModel.playerName,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    Row(verticalAlignment = Alignment.Top) {
                        Text(text = "Pozitie: ", style = MaterialTheme.typography.labelSmall)
                        Text(
                            text = playerModel.playerPosition,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = CenterVertically,
                modifier = Modifier.weight(0.3f).fillMaxWidth()
            ) {

                Text(
                    text = playerModel.playerShirtNumber,
                    fontFamily = rapid_font,
                    fontSize = 80.sp,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(CenterVertically)
                )
            }
        }

    }

}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PlayerItemPreview() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    ) {
        PlayerItemView(
            playerModel = PlayerModel(
                playerName = "Horatiu Moldovan",
                playerPosition = "Portar",
                playerAge = 24,
                playerBirthDate = Date(1990, 6, 26),
                playerGoals = 0,
                playerIcon = R.drawable.player_31_moldovan,
                playerMatches = 30,
                playerGoalsCurrentSeason = 0,
                playerMatchesCurrentSeason = 30,
                playerShirtNumber = "31"
            )
        )
    }
}