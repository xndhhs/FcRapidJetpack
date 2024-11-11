package ro.fcrapid.fcrapidjetpack.ui.views.dashboard

import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewEvent
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewSideEffect
import ro.fcrapid.fcrapidjetpack.ui.views.base.ViewState
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem

class DashboardContract {

    sealed class Event: ViewEvent {
        data object OnMenu : Event()
        data object OnBack : Event()

        sealed class BottomNavEvent: Event() {
            data class OnBottomRouteChanged(val route: String): BottomNavEvent()
        }
    }

    data class State(
        val currentRoute: String,
        val showInFullScreen: Boolean,
        val shouldShowNavDrawer: Boolean,
        val bottomNavigationItems: List<HomeNavigationItem>,
        val shouldShowBottomNavigationItems: Boolean
    ) : ViewState

    data class NavDrawerMenuItem(
        val itemId: Int,
        val nameResource: String,
        val iconResource: String
    )

    sealed class Effect: ViewSideEffect {
        sealed class Navigation: Effect() {
            data object ToFirstTeamScreen: Navigation()
        }
    }
}