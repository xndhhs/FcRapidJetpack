package ro.fcrapid.fcrapidjetpack.ui.views.shared_components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.fcrapid.fcrapidjetpack.ui.theme.FcRapidJetpackTheme
import ro.fcrapid.fcrapidjetpack.ui.views.dashboard.DashboardContract

@Composable
fun DashboardHeader(
    name: String,
    isAccountScreenActive: Boolean,
    onEventSent: (DashboardContract.Event) -> Unit,
    onMenuEventSent: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                if (isAccountScreenActive) {
                    MaterialTheme.colorScheme.secondary
                } else {
                    MaterialTheme.colorScheme.tertiary
                }
            )
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        val headerTextColorResource = if (isAccountScreenActive) {
            MaterialTheme.colorScheme.tertiary
        } else {
            MaterialTheme.colorScheme.tertiaryContainer
        }

    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DashboardHeaderPreview() {
    FcRapidJetpackTheme {
        Surface(color = MaterialTheme.colorScheme.primary) {
            DashboardHeader(name = "Home", isAccountScreenActive = true, onEventSent = {}) {

            }
        }
    }
}