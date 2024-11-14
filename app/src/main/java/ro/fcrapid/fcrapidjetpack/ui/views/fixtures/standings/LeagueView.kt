package ro.fcrapid.fcrapidjetpack.ui.views.fixtures.standings

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import ro.fcrapid.fcrapidjetpack.models.TeamModel
import ro.fcrapid.fcrapidjetpack.ui.theme.small
import ro.fcrapid.fcrapidjetpack.ui.theme.standard
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HorizontalSpacer
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.VerticalSpacer


@Composable
fun LeagueView(teamsList: List<TeamModel>) {
        VerticalSpacer(height = standard)
        LazyColumn(userScrollEnabled = true) {
            item {
                LeagueHeaderItemView(
                headerTitlesTextStyle = MaterialTheme.typography.bodySmall,
                headerTitlesBackGroundColor = MaterialTheme.colorScheme.primary,
            ) }
            items(
                count = teamsList.size,
                key = { teamsList[it].teamPosition },
                contentType = { TeamModel::class.java },
                itemContent = { index ->
                    LeagueTeamItemView(
                        team = teamsList[index],
                        headerTitlesTextStyle = MaterialTheme.typography.labelSmall,
                        headerTitlesBackGroundColor = if (index % 2 == 0)
                                MaterialTheme.colorScheme.background
                                else MaterialTheme.colorScheme.outlineVariant
                    )
                }
            )
            item {
                LeagueTableAdditionalNote(
                    "intră în play-off (tur-retur, in total 10 etape)",
                    MaterialTheme.colorScheme.tertiary
                )
            }
            item {
                LeagueTableAdditionalNote("vor continua în play-out (manșă unică, in total 9 etape)",
                    MaterialTheme.colorScheme.error)
            }
        }
    }

@Composable
private fun LeagueTableAdditionalNote(text: String, color: Color) {
    Column (modifier = Modifier.padding(small)){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .size(standard)
                .background(color))
            HorizontalSpacer(width = small)
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                fontStyle = FontStyle.Italic
            )
        }
    }
}
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LeaguePreview() {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        LeagueView(
            teamsList = listOf(
                TeamModel("FC Hermanstadt", "1", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "2", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "3", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "4", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "5", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "6", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "7", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "8", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "9", "12", "9", "12", "2", "22:19", "33"),
                TeamModel("FC Hermanstadt", "10", "12", "9", "12", "2", "22:19", "33"),

                )
        )
    }
}