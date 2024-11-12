package ro.fcrapid.fcrapidjetpack.ui.navigation.dashboard

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.NEWS
import ro.fcrapid.fcrapidjetpack.ui.navigation.navigateToFirstTeamTab
import ro.fcrapid.fcrapidjetpack.ui.navigation.navigateToFixturesTab
import ro.fcrapid.fcrapidjetpack.ui.navigation.navigateToNewsTab
import ro.fcrapid.fcrapidjetpack.ui.navigation.navigateToProfileTab
import ro.fcrapid.fcrapidjetpack.ui.views.base.SIDE_EFFECTS_KEY
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Effect.BottomNavigation.ToFirstTeam
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Effect.BottomNavigation.ToFixtures
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Effect.BottomNavigation.ToNews
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Effect.BottomNavigation.ToProfile
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Effect.Navigation.ToFirstTeamScreen
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.BottomNavEvent.OnBottomRouteChanged
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardScreen
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardViewModel

@Composable
fun DashboardDestination(
    navController: NavController,
    bottomNavController: NavController
) {
    val viewModel = koinViewModel<DashboardViewModel>()
    val activity = LocalContext.current as Activity

    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val route = navBackStackEntry?.destination?.route

    if (viewModel.viewState.value.currentRoute != route) {
        viewModel.setEvent(
            OnBottomRouteChanged(route ?: NEWS)
        )
    }

    DashboardScreen(
        viewState = viewModel.viewState,
        navController = navController,
        bottomNavController = bottomNavController,
        onEventSent = { event -> viewModel.setEvent(event) }
    )

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
                is DashboardContract.Effect.BottomNavigation ->
                    when (effect) {
                        ToFirstTeam -> bottomNavController.navigateToFirstTeamTab()
                        ToFixtures -> bottomNavController.navigateToFixturesTab()
                        ToNews -> bottomNavController.navigateToNewsTab()
                        ToProfile -> bottomNavController.navigateToProfileTab()
                    }
                is DashboardContract.Effect.Navigation ->
                    when (effect) {
                        ToFirstTeamScreen ->  { }
                    }
            }
        }.collect()
    }
}