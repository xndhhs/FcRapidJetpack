package ro.fcrapid.fcrapidjetpack.ui.views.news_screen

import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewEvent
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewSideEffect
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewState

class NewsContract {

    sealed class Event: ViewEvent {
        data object OnNewsDetails : Event()

    }
    data class State(
       val newsList: List<String>
    ) : ViewState

    sealed class Effect: ViewSideEffect {
        sealed class Navigation: Effect() {
            data object ToNewsDetails: Navigation()
        }
    }
}