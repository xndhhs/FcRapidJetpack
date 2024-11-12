package ro.fcrapid.fcrapidjetpack.ui.views.fixtures

import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewEvent
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewSideEffect
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewState

class FixturesContract {

    sealed class Event: ViewEvent {
        data object OnResults: Event()
        data object UpcomingGames: Event()
        data object OnStandings: Event()

    }
    data class State(
        val gamesList: List<String>
    ) : ViewState

    sealed class Effect: ViewSideEffect {
        sealed class Navigation: Effect() {
        }
    }
}