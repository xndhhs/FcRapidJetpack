package ro.fcrapid.fcrapidjetpack.ui.views.fixtures

import ro.fcrapid.fcrapidjetpack.models.TeamModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewEvent
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewSideEffect
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewState

class FixturesContract {

    sealed class Event: ViewEvent {
        data object OnResults: Event()
        data object UpcomingGames: Event()
        data object OnStandings: Event()

        data class OnHeaderTabSelected(val tabHeader: FixturesTabHeaders) : Event()
    }
    data class State(
        val upcomingGamesList: List<String>,
        val pastResultsList: List<String>,
        val teamsList: List<TeamModel>,
        val tabHeaders: List<FixturesTabHeaders>,
        val selectedTab: Int
    ) : ViewState

    enum class FixturesTabHeaders(val label: String){
        REZULTATE("Rezultate"),
        MECIURI_VIITOARE("Meciuri"),
        CLASAMENT("Clasament")
    }
    sealed class Effect: ViewSideEffect {
        sealed class Navigation: Effect() {
        }
    }
}