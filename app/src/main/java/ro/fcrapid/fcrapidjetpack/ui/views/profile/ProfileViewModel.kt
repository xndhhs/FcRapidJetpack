package ro.fcrapid.fcrapidjetpack.ui.views.profile

import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileContract.Effect
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileContract.Event
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileContract.Event.OnProfileDetails
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileContract.State

class ProfileViewModel(
    savedStateHandle: SavedStateHandle,
    appBackgroundEventHandler: AppBackgroundEventHandler
) : BaseViewModel<Event, State, Effect>(savedStateHandle, appBackgroundEventHandler) {


    override fun setInitialState(): State {
        return State(
            name = ""
        )
    }

    override fun handleEvents(event: Event) {
        when (event) {
            OnProfileDetails -> {}
        }
    }
}
