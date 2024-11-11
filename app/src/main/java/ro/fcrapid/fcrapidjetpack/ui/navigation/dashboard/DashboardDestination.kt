package ro.fcrapid.fcrapidjetpack.ui.navigation.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.SIDE_EFFECTS_KEY
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Effect.Navigation.ToFirstTeamScreen
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardScreen
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardViewModel

@Composable
fun DashboardDestination(bottomController: NavController) {
    val viewModel = koinViewModel<DashboardViewModel>()
    val context = LocalContext.current

    DashboardScreen(
        viewState = viewModel.viewState,
        navController = null,
        bottomNavController = null,
        onEventSent = {}
    )

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach {  effect ->
            when (effect) {
                ToFirstTeamScreen -> { bottomController.popBackStack() }  // to update
            }
        }
    }
}