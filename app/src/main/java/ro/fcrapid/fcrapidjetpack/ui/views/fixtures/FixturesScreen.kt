package ro.fcrapid.fcrapidjetpack.ui.views.fixtures

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import ro.fcrapid.fcrapidjetpack.ui.theme.small
import ro.fcrapid.fcrapidjetpack.ui.theme.standard
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesContract.Event
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesContract.State
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.standings.LeagueView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FixturesScreen(
    viewState: androidx.compose.runtime.State<State>,
    onEventSent: (event: Event) -> Unit
) {
    val state = viewState.value
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(standard)
            .fillMaxSize()
    ) {
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
                        onClick = { onEventSent(Event.OnHeaderTabSelected(tabHeader)) }
                    ) {
                        Text(text = tabHeader.label, modifier = Modifier.padding(small))
                    }
                }
            }
        )
        when (state.selectedTab) {
            0 -> { ResultsView(state) }
            1 -> { UpcomingGamesView(state)}
            2 -> { LeagueView(teamsList = state.teamsList) }
        }
    }
}

@Composable
fun ResultsView(state: State) {
    Text(text = "Results")
}

@Composable
fun UpcomingGamesView(state: State) {
    Text(text = "Upcoming Games")
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FixturesScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        val viewState = remember {
            mutableStateOf(
                State(
                    upcomingGamesList = listOf(),
                    pastResultsList = listOf(),
                    teamsList = listOf(),
                    tabHeaders = listOf(),
                    selectedTab = 1158
                )
            )
        }
        FixturesScreen(viewState) {}
    }
}