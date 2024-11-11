package ro.fcrapid.fcrapidjetpack.ui.views.dashboard

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract.State

@Composable
fun DashboardScreen(
    viewState: androidx.compose.runtime.State<State>,
    navController: NavController? = null,
    bottomNavController: NavController? = null,
    onEventSent: () -> Unit
) {
    val state = viewState.value
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    BackHandler {
        if (drawerState.isOpen) {
            coroutineScope.launch { drawerState.close() }
        } else {
            onEventSent
        }
    }
    NavigationDrawer(
        drawerState,
        coroutineScope,
        onEventSent,
        bottomNavController,
        navController
    )

    Text(text = "Dashboard")
}

@Composable
private fun NavigationDrawer(
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    onEventSent: () -> Unit,
    navController: NavController? = null,
    bottomNavController: NavController? = null
) {
    ModalNavigationDrawer(drawerContent = { }) {
        DashboardContent(
            onEventSent,
            coroutineScope,
            drawerState,
            bottomNavController,
            navController
        )
    }
}

@Composable
fun DashboardContent(
    onEventSent: () -> Unit,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState,
    bottomNavController: NavController?,
    navController: NavController?
) {
//    Scaffold(
//        topBar = {}
//    )
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
                    shouldShouNavDrawer = false
                )
            )
        }
        DashboardScreen(
            viewState = viewState,
            navController = null,
            bottomNavController = null,
            onEventSent = {}
        )
    }
}