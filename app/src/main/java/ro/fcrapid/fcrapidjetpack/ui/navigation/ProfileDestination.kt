package ro.fcrapid.fcrapidjetpack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.SIDE_EFFECTS_KEY
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileContract.Effect.Navigation.ToProfileDetails
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileScreen
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileViewModel

@Composable
fun ProfileDestination(
    bottomNavHostController: NavHostController,
    hideMenu: () -> Unit,
    isMenuOpen: Boolean
) {
    val viewModel = koinViewModel<ProfileViewModel>()
    val context = LocalContext.current


    ProfileScreen(
        viewState = viewModel.viewState,
        onEventSent = { event -> viewModel.setEvent(event) }
    )

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
                // to update
                ToProfileDetails -> {}
            }
        }
    }
}