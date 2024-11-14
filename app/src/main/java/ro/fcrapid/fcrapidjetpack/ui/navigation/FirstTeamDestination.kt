package ro.fcrapid.fcrapidjetpack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamScreen
import ro.fcrapid.fcrapidjetpack.ui.views.base.SIDE_EFFECTS_KEY
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.Effect.Navigation.ToPlayerDetails
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamContract.Effect.Navigation.ToStaffDetails
import ro.fcrapid.fcrapidjetpack.ui.views.first_team.FirstTeamViewModel


@Composable
fun FirstTeamDestination(
    bottomNavHostController: NavHostController,
    hideMenu: () -> Unit,
    isMenuOpen: Boolean
) {
    val viewModel = koinViewModel<FirstTeamViewModel>()
    val context = LocalContext.current


    FirstTeamScreen(
        viewState = viewModel.viewState,
        onEventSent = { event -> viewModel.setEvent(event) }
    )

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
                // to update
                ToPlayerDetails -> { }
                ToStaffDetails -> { }
            }
        }
    }
}