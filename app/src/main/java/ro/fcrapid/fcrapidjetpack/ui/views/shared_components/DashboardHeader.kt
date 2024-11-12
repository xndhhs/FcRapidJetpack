package ro.fcrapid.fcrapidjetpack.ui.views.shared_components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.fcrapid.fcrapidjetpack.common.TyrianSymbols.MENU
import ro.fcrapid.fcrapidjetpack.ui.theme.FcRapidJetpackTheme
import ro.fcrapid.fcrapidjetpack.ui.theme.tyrian_font

@Composable
fun DashboardHeader(
    name: String,
    isNewsScreenActive: Boolean,
    onMenuEventSent: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                if (isNewsScreenActive) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.background
                }
            )
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        val headerTextColor = if (isNewsScreenActive)
            MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface

        Text(text = MENU,
            fontFamily = tyrian_font,
            color = headerTextColor,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.clickable { onMenuEventSent() }
        )
        Text(
            text = name,
            color = headerTextColor,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()

        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DashboardHeaderPreview() {
    FcRapidJetpackTheme {
        Surface(color = MaterialTheme.colorScheme.primary) {
            DashboardHeader(name = "Home", isNewsScreenActive = true) {
            }
        }
    }
}