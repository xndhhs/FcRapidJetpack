package ro.fcrapid.fcrapidjetpack.ui.views.fixtures.standings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.fcrapid.fcrapidjetpack.models.TeamModel
import ro.fcrapid.fcrapidjetpack.ui.theme.xLarge

@Composable
fun LeagueTeamItemView(
    team: TeamModel,
    headerTitlesTextStyle: TextStyle,
    headerTitlesBackGroundColor: Color,
) {
    Column {
        Row(Modifier.fillMaxWidth().background(headerTitlesBackGroundColor)) {
            TeamPositionFieldItem(label = team.teamPosition, headerTitlesTextStyle, Modifier.weight(2f))
            TeamValueFieldItem(label = team.teamName, headerTitlesTextStyle, Modifier.weight(7f))
            TeamValueFieldItem(label = team.matchesPlayed, headerTitlesTextStyle, Modifier.weight(2f))
            TeamValueFieldItem(label = team.matchesWon, headerTitlesTextStyle, Modifier.weight(2f))
            TeamValueFieldItem(label = team.matchesDrew, headerTitlesTextStyle, Modifier.weight(2f))
            TeamValueFieldItem(label = team.matchesLost, headerTitlesTextStyle, Modifier.weight(2f))
            TeamValueFieldItem(label = team.goalDifferential, headerTitlesTextStyle, Modifier.weight(2f))
            TeamValueFieldItem(label = team.points, headerTitlesTextStyle, Modifier.weight(2f))
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.onSurface, thickness = (0.75.dp))
    }
}


@Composable
private fun TeamValueFieldItem(
    label: String,
    headerTitlesTextStyle: TextStyle,
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            style = headerTitlesTextStyle,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .height(xLarge)
                .wrapContentHeight(),
        )
    }
}

@Composable
private fun TeamPositionFieldItem(
    label: String,
    headerTitlesTextStyle: TextStyle,
    modifier: Modifier
) {
    Box(
        modifier = modifier.background(
            color = if (label.toInt() <= 6) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error
        ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            style = headerTitlesTextStyle,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.background,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .height(xLarge)
                .wrapContentHeight(),
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TableTeamPreview() {
    val modelTeam = TeamModel("FC Hermanstadt", "12", "12", "9", "12", "2", "22:19", "33")

    LeagueTeamItemView(
        team = modelTeam,
        headerTitlesTextStyle = MaterialTheme.typography.labelMedium,
        headerTitlesBackGroundColor = MaterialTheme.colorScheme.outline

    )
}