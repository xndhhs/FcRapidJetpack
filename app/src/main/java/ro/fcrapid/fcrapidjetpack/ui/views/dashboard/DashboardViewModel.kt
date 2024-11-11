package ro.fcrapid.fcrapidjetpack.ui.views.dashboard


import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.FIXTURES
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.NEWS
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.PROFILE
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.TEAM
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.*
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.*

class DashboardViewModel(
    savedStateHandle: SavedStateHandle,
    appBackgroundEventHandler: AppBackgroundEventHandler
) : BaseViewModel<Event, State, Effect>(savedStateHandle, appBackgroundEventHandler) {

    override fun setInitialState(): State {
        return State(
            shouldShowNavDrawer = false,
            showInFullScreen = false,
            currentRoute = "",
            bottomNavigationItems = listOf(),
            shouldShowBottomNavigationItems = false,
        )
    }

    override fun handleEvents(event: Event) {
        when (event) {
            OnMenu -> { TODO() }

            OnBack -> { TODO() }

            is BottomNavEvent.OnBottomRouteChanged -> setState {
                copy(
                    currentRoute = event.route,
                    showInFullScreen = shouldShowInFullScreen(event.route)
                )
            }
        }
    }

    private fun shouldShowInFullScreen(currentRoute: String) =
        listOf(NEWS, FIXTURES, TEAM, PROFILE).none { it == currentRoute}

}