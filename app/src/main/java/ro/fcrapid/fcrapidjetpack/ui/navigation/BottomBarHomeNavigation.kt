package ro.fcrapid.fcrapidjetpack.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.FIXTURES
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.NEWS
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.PROFILE
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.TEAM


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
        composable(route = NEWS) {
            NewsDestination(navController, bottomController)
        }

        composable(route = FIXTURES) {
            FixturesDestination(navController, hideMenu, isMenuOpen)
        }

        composable(route = TEAM) {
            FirstTeamDestination(navController, hideMenu, isMenuOpen)
        }

        composable(route = PROFILE) {
            ProfileDestination(navController, hideMenu, isMenuOpen)
        }
    }
}

object BottomBarNavRoutes {
    const val NEWS = "news"
    const val FIXTURES = "fixtures"
    const val TEAM = "team"
    const val PROFILE = "profile"
}

fun NavController.navigateToNewsTab() {
    navigate(NEWS){
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        //Avoid multiple copies of the same destination when reselecting the same item
        launchSingleTop = true
        restoreState = false
    }
}

fun NavController.navigateToFixturesTab() {
    navigate(FIXTURES){
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        //Avoid multiple copies of the same destination when reselecting the same item
        launchSingleTop = true
        restoreState = false
    }
}

fun NavController.navigateToFirstTeamTab() {
    navigate(TEAM){
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        //Avoid multiple copies of the same destination when reselecting the same item
        launchSingleTop = true
        restoreState = false
    }
}

fun NavController.navigateToProfileTab() {
    navigate(PROFILE){
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        //Avoid multiple copies of the same destination when reselecting the same item
        launchSingleTop = true
        restoreState = false
    }
}



