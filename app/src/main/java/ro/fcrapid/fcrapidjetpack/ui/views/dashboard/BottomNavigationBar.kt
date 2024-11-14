package ro.fcrapid.fcrapidjetpack.ui.views.dashboard

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ro.fcrapid.fcrapidjetpack.common.TyrianSymbols
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.FIXTURES
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.NEWS
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.PROFILE
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.TEAM
import ro.fcrapid.fcrapidjetpack.ui.theme.tyrian_font
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.BottomNavEvent.OnFirstTeam
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.BottomNavEvent.OnFixtures
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.BottomNavEvent.OnNews
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.BottomNavEvent.OnProfile
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem.FirstTeam
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem.Fixtures
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem.News
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem.Profile

@Composable
fun BottomNavigationBar(
    navigationItems: List<HomeNavigationItem> = arrayListOf(),
    onEventSent: (event: Event) -> Unit,
    activeRoute: String
) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
        navigationItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Text(
                        text = item.icon,
                        fontFamily = tyrian_font,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.inverseSurface,
                    unselectedTextColor = MaterialTheme.colorScheme.inverseSurface,
                    indicatorColor = MaterialTheme.colorScheme.outlineVariant
                ),
                selected = activeRoute == item.route,
                onClick = { onEventSent(getEventsFromItem(item)) }
            )
        }
    }
}

private fun getEventsFromItem(navigationItem: HomeNavigationItem): Event {
    return when (navigationItem) {
        is News -> OnNews
        is Fixtures -> OnFixtures
        is FirstTeam -> OnFirstTeam
        is Profile -> OnProfile
        else -> OnNews
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        navigationItems = listOf(
            HomeNavigationItem(NEWS, TyrianSymbols.HOME, "Stiri"),
            HomeNavigationItem(FIXTURES, TyrianSymbols.FIXTURES, "Rezultate"),
            HomeNavigationItem(TEAM, TyrianSymbols.TEAM, "Echipa"),
            HomeNavigationItem(PROFILE, TyrianSymbols.PROFILE, "Profil"),
        ), {}, "news"
    )
}