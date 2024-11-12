package ro.fcrapid.fcrapidjetpack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.SIDE_EFFECTS_KEY
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesScreen
import ro.fcrapid.fcrapidjetpack.ui.views.fixtures.FixturesViewModel

@Composable
fun FixturesDestination(
    bottomNavController: NavController,
    hideMenu: () -> Unit,
    isMenuOpen: Boolean
) {

    val viewModel = koinViewModel<FixturesViewModel>()
    val context = LocalContext.current

    FixturesScreen(
        viewState = viewModel.viewState,
        onEventSent = { event -> viewModel.setEvent(event) }
    )

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
                // to update
                else -> {}
            }
        }
    }
}