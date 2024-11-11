package ro.fcrapid.fcrapidjetpack.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.NEWS


const val ROOT_ROUTE = "bottom_bar_root"

@Composable
fun BottomBarHomeNavigation(
    isMenuOpen: Boolean,
    hideMenu: () -> Unit,
    bottomController: NavHostController,
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NEWS,
        route = ROOT_ROUTE,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(route = NEWS) { /*TODO*/ }
    }
}

object BottomBarNavRoutes {
    const val NEWS = "news"
    const val FIXTURES = "fixtures"
    const val TEAM = "team"
    const val PROFILE = "profile"
}