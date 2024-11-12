package ro.fcrapid.fcrapidjetpack.ui.views.news_screen


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
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsContract.Event
import ro.fcrapid.fcrapidjetpack.ui.views.news_screen.NewsContract.State

@Composable
fun NewsScreen(
    viewState: androidx.compose.runtime.State<State>,
    onEventSent: (event: Event) -> Unit
) {
    val state = viewState.value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement =  Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "News Screen")
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SponsorScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        val viewState = remember {
            mutableStateOf(
                State(
                    newsList = listOf()
                )
            )
        }
        NewsScreen(viewState) {}
    }
}