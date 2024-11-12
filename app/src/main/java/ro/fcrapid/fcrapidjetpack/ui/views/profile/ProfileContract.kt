package ro.fcrapid.fcrapidjetpack.ui.views.profile

import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewEvent
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewSideEffect
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewState

class ProfileContract {
    sealed class Event: ViewEvent {
        data object OnProfileDetails : Event()

    }
    data class State(
        val name: String
    ) : ViewState

    sealed class Effect: ViewSideEffect {
        sealed class Navigation: Effect() {
            data object ToProfileDetails: Navigation()
        }
    }
}
