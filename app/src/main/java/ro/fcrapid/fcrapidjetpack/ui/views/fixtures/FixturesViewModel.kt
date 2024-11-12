package ro.fcrapid.fcrapidjetpack.ui.views.fixtures

import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesContract.*
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesContract.Event.*

class FixturesViewModel(
    savedStateHandle: SavedStateHandle,
    appBackgroundEventHandler: AppBackgroundEventHandler
) : BaseViewModel<Event, State, Effect>(savedStateHandle, appBackgroundEventHandler) {


    override fun setInitialState(): State {
        return State(
            gamesList = listOf()
        )
    }

    override fun handleEvents(event: Event) {
        when (event) {
            OnResults -> { }
            OnStandings ->  { }
            UpcomingGames ->  { }
        }
    }
}