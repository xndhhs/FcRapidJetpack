package ro.fcrapid.fcrapidjetpack.ui.views.dashboard

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ro.fcrapid.fcrapidjetpack.common.TyrianSymbols
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarHomeNavigation
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.FIXTURES
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.NEWS
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.PROFILE
import ro.fcrapid.fcrapidjetpack.ui.navigation.BottomBarNavRoutes.TEAM
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.*
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.Event.OnBack
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.DashboardHeader
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HomeNavigationItem

@Composable
fun DashboardScreen(
    viewState: androidx.compose.runtime.State<State>,
    navController: NavController? = null,
    bottomNavController: NavController? = null,
    onEventSent: (event: Event) -> Unit
) {
    val state = viewState.value
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    BackHandler {
        if (drawerState.isOpen) {
            coroutineScope.launch { drawerState.close() }
        } else {
            onEventSent(OnBack)
        }
    }
    NavigationDrawer(
        state,
        drawerState,
        coroutineScope,
        onEventSent,
        bottomNavController,
        navController
    )
}

@Composable
private fun NavigationDrawer(
    state: State,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    onEventSent: (event: Event) -> Unit,
    navController: NavController? = null,
    bottomNavController: NavController? = null
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            NavDrawerBody(navDrawerMenuItems = listOf(),
                onItemClick = {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                }

            )
        }


    ) {
        DashboardContent(
            state,
            onEventSent,
            coroutineScope,
            drawerState,
            bottomNavController,
            navController
        )
    }
}

@Composable
fun NavDrawerBody(
    navDrawerMenuItems: List<NavDrawerMenuItem>,
    modifier: Modifier = Modifier,
    onItemClick: (NavDrawerMenuItem) -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
            .background(MaterialTheme.colorScheme.onSurfaceVariant)
            .fillMaxHeight()
            .fillMaxWidth(0.7f)
            .padding(12.dp)
    ) {

    }
}

@Composable
fun DashboardContent(
    state: State,
    onEventSent: (event: Event) -> Unit,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState,
    bottomNavController: NavController?,
    navController: NavController?
) {
    Scaffold(
        topBar = {
            if (!state.showInFullScreen) {
                val headerText: String = when (state.currentRoute) {
                    NEWS -> "Stiri"
                    FIXTURES -> "Rezultate"
                    TEAM -> "Echipa"
                    PROFILE -> "Profil"
                    else -> ""
                }

                val focusManager = LocalFocusManager.current

                DashboardHeader(
                    name = headerText,
                    isNewsScreenActive = state.currentRoute == NEWS,
                    onMenuEventSent = {
                        focusManager.clearFocus()
                        coroutineScope.launch { drawerState.open() }
                    }
                )
            }
        },
        bottomBar = {
            if (!state.showInFullScreen && !state.shouldHideBottomNavigationItems) {
                SetNavigationItemsResources(bottomNavigationItems = state.bottomNavigationItems)
                BottomNavigationBar(
                    navigationItems = state.bottomNavigationItems,
                    onEventSent = onEventSent,
                    activeRoute = state.currentRoute
                )
            }
        },
        content = { innerPadding ->
            BottomBarHomeNavigation(
                isMenuOpen = drawerState.isOpen,
                hideMenu = { coroutineScope.launch { drawerState.close() } },
                bottomController = bottomNavController as NavHostController,
                navController = navController as NavHostController,
                modifier = Modifier.padding(innerPadding)
            )

        }
    )
}


@Composable
private fun SetNavigationItemsResources(bottomNavigationItems: List<HomeNavigationItem>) {
    bottomNavigationItems.forEach {
        when (it) {
            is HomeNavigationItem.News -> {
                it.icon = TyrianSymbols.HOME
                it.title = "Stiri"
            }

            is HomeNavigationItem.Fixtures -> {
                it.icon = TyrianSymbols.FIXTURES
                it.title = "Rezultate"
            }

            is HomeNavigationItem.FirstTeam -> {
                it.icon = TyrianSymbols.TEAM
                it.title = "Echipa"
            }

            is HomeNavigationItem.Profile -> {
                it.icon = TyrianSymbols.PROFILE
                it.title = "Profil"
            }
        }
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DashboardScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        val viewState = remember {
            mutableStateOf(
                State(
                    shouldShowNavDrawer = false,
                    showInFullScreen = false,
                    currentRoute = "",
                    bottomNavigationItems = listOf(),
                    shouldHideBottomNavigationItems = false,
                )
            )
        }
        DashboardScreen(
            viewState = viewState,
            onEventSent = {}
        )
    }
}