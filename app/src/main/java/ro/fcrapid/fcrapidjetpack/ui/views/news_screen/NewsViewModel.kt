package ro.fcrapid.fcrapidjetpack.ui.views.news_screen

import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsContract.Effect
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsContract.Event
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsContract.State

class NewsViewModel(
    savedStateHandle: SavedStateHandle,
    appBackgroundEventHandler: AppBackgroundEventHandler
) : BaseViewModel<Event, State, Effect>(savedStateHandle, appBackgroundEventHandler) {


    override fun setInitialState(): State {
        return State(
            newsList = listOf()
        )
    }

    override fun handleEvents(event: Event) {
        when (event) {
            Event.OnNewsDetails -> {  }
        }
    }

}