package ro.fcrapid.fcrapidjetpack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel
import ro.fcrapid.fcrapidjetpack.ui.views.base.SIDE_EFFECTS_KEY
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsContract.Effect.Navigation.ToNewsDetails
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsScreen
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsViewModel

@Composable
fun NewsDestination(
    navHostController: NavHostController,
    bottomNavHostController: NavHostController
) {
    val viewModel = koinViewModel<NewsViewModel>()
    val context = LocalContext.current


    NewsScreen(
        viewState = viewModel.viewState,
        onEventSent = { event -> viewModel.setEvent(event) }
    )

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
         // to update
                ToNewsDetails -> { }
            }
        }
    }
}