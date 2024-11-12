package ro.fcrapid.fcrapidjetpack.ui.views.dashboard


import androidx.lifecycle.SavedStateHandle
import ro.fcrapid.fcrapidjetpack.app_services.app_activity_timeout.AppBackgroundEventHandler
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.FIXTURES
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.NEWS
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.PROFILE
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.TEAM
import ro.fcrapid.fcrapidjetpack.ui.views.base.BaseViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.*
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Effect.BottomNavigation.*
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.*
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.BottomNavEvent.*
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem

class DashboardViewModel(
    savedStateHandle: SavedStateHandle,
    appBackgroundEventHandler: AppBackgroundEventHandler
) : BaseViewModel<Event, State, Effect>(savedStateHandle, appBackgroundEventHandler) {

    override fun setInitialState(): State {
        return State(
            shouldShowNavDrawer = false,
            showInFullScreen = false,
            currentRoute = "",
            bottomNavigationItems = listOf(
                HomeNavigationItem.News(NEWS),
                HomeNavigationItem.Fixtures(FIXTURES),
                HomeNavigationItem.FirstTeam(TEAM),
                HomeNavigationItem.Profile(PROFILE)
            )
            ,
            shouldHideBottomNavigationItems = false,
        )
    }

    init {
        setState {
            copy(
                bottomNavigationItems = listOf(
                    HomeNavigationItem.News(NEWS),
                    HomeNavigationItem.Fixtures(FIXTURES),
                    HomeNavigationItem.FirstTeam(TEAM),
                    HomeNavigationItem.Profile(PROFILE)
                )
            )
        }
    }

    override fun handleEvents(event: Event) {
        when (event) {
            OnMenu -> {  }
            OnBack -> {  }

            is OnBottomRouteChanged -> setState {
                copy(
                    currentRoute = event.route,
                    showInFullScreen = shouldShowInFullScreen(event.route)
                )
            }
            OnFirstTeam -> { setEffect { ToFirstTeam } }
            OnFixtures -> { setEffect { ToFixtures } }
            OnNews -> { setEffect { ToNews } }
            OnProfile -> { setEffect { ToProfile } }
        }
    }

    private fun shouldShowInFullScreen(currentRoute: String) =
        listOf(NEWS, FIXTURES, TEAM, PROFILE).none { it == currentRoute}

}