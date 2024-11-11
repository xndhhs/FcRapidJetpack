package ro.fcrapid.fcrapidjetpack.ui.views.dashboard



import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.*
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.*

class DashboardViewModel(
    savedStateHandle: SavedStateHandle,
    appBackgroundEventHandler: AppBackgroundEventHandler
) : BaseViewModel<Event, State, Effect>(savedStateHandle, appBackgroundEventHandler) {

    override fun setInitialState() : State{
     return State(
         shouldShouNavDrawer = false
     )
    }
    override fun handleEvents(event: Event) {
        when (event) {
            OnMenu -> { TODO() }
        }
    }

}