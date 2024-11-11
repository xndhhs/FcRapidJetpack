package ro.fcrapid.fcrapidjetpack.ui.views.dashboard

import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewEvent
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewSideEffect
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewState

class DashboardContract {

    sealed class Event: ViewEvent {
        data object OnMenu : Event()
    }

    data class State(
        val shouldShouNavDrawer: Boolean
    ) : ViewState

    sealed class Effect: ViewSideEffect {
        sealed class Navigation: Effect() {
            data object ToFirstTeamScreen: Navigation()
        }
    }
}