package ro.fcrapid.fcrapidjetpack.ui.views.dashboard

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ro.fcrapid.fcrapidjetpack.ui.theme.tyrian_font
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.*
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem

@Composable
fun BottomNavigationBar(
    navigationItems: List<HomeNavigationItem> = arrayListOf(),
    onEventSent: (event: Event) -> Unit,
    activeRoute: String
) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.onSurface) {
        navigationItems.forEach{ item ->
            NavigationBarItem(
                icon = {
                    Text(text = item.icon, fontFamily = tyrian_font, style = MaterialTheme.typography.labelSmall)
                },
                label = { Text(text = item.title, style = MaterialTheme.typography.labelSmall) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSecondary
                ),
                selected = activeRoute == item.route,
                onClick = { onEventSent(getEventsFromItem(item)) }
            )
        }
    }
}

private fun getEventsFromItem(navigationItem: HomeNavigationItem): Event {
    return when (navigationItem) {
        is HomeNavigationItem.News -> { TODO() }
        is HomeNavigationItem.Fixtures -> { TODO() }
        is HomeNavigationItem.FirstTeam -> { TODO() }
        is HomeNavigationItem.MyAccount -> { TODO() }
        else -> { TODO() }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(arrayListOf(), {}, "")
}