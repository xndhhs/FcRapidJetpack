package ro.fcrapid.fcrapidjetpack.ui.views.fixtures

import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.models.TeamModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesContract.*
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesContract.Event.*
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesContract.FixturesTabHeaders.*

class FixturesViewModel(
    savedStateHandle: SavedStateHandle,
    appBackgroundEventHandler: AppBackgroundEventHandler
) : BaseViewModel<Event, State, Effect>(savedStateHandle, appBackgroundEventHandler) {


    override fun setInitialState(): State {
        return State(
            upcomingGamesList = listOf(),
            pastResultsList = listOf(),
            teamsList = listOf(
                    TeamModel("FC Rapid", "1", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("FC Hermanstadt", "2", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("FC Botosani", "3", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("Universitatea Craiova", "4", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("Sepsi OSK", "5", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("UTA ARAD", "6", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("FCSB", "7", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("Dinamo", "8", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("U Cluj ", "9", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("CFR Cluj", "10", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("Farul", "11", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("Poli Iasi", "12", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("G. Buzau", "13", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("Otelul", "14", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("Petrolul", "15", "12", "9", "12", "2", "22:19", "33"),
                    TeamModel("Slobozia", "16", "12", "9", "12", "2", "22:19", "33"),
            ),
            tabHeaders = listOf(REZULTATE, MECIURI_VIITOARE, CLASAMENT),
            selectedTab = 0,

        )
    }

    override fun handleEvents(event: Event) {
        when (event) {
            OnResults -> { }
            OnStandings ->  { }
            UpcomingGames ->  { }
            is OnHeaderTabSelected -> {
                setState { copy(selectedTab = tabHeaders.indexOf(event.tabHeader)) }
            }
        }
    }
}