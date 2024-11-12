package ro.fcrapid.fcrapidjetpack.ui.views.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileContract.Event
import ro.fcrapid.fcrapidjetpack.ui.views.profile.ProfileContract.State

@Composable
fun ProfileScreen(
    viewState: androidx.compose.runtime.State<State>,
    onEventSent: (event: Event) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Profile Screen")
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        val viewState = remember {
            mutableStateOf(
                State(
                    name = "John Doe"
                )
            )
        }
        ProfileScreen(viewState) {}
    }
}