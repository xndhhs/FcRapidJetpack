package ro.fcrapid.fcrapidjetpack.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ro.fcrapid.fcrapidjetpack.ui.navigation.NavRoutes.DASHBOARD
import ro.fcrapid.fcrapidjetpack.ui.navigation.dashboard.DashboardDestination

const val MAIN_ROUTE = "main_root"

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = DASHBOARD,
        route = MAIN_ROUTE,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(route = DASHBOARD) {
            val bottomNavController = rememberNavController()
            DashboardDestination(
                navController = navController,
                bottomNavController = bottomNavController
            )
        }
    }
}

object NavRoutes {
    const val DASHBOARD = "dashboard"
}