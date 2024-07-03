package ro.fcrapid.fcrapidjetpack.ui.contact

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.ui.theme.tyrian_font

@Composable
fun ContactDetailsItemView(
    contactSymbol: String,
    sectionTitle: String,
    phoneNumber: String?,
    email: String?,
    additionalInfo: String?
) {
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Text(
            text = contactSymbol,
            modifier = Modifier.padding(top = 4.dp),
            fontFamily = tyrian_font,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = sectionTitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.clickable {  }
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (phoneNumber != null) {
                Text(
                    text = phoneNumber,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            if (email != null) {
                Text(
                    text = email,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.clickable { }
                )
            }
            if (additionalInfo != null) {
                Text(
                    text = additionalInfo,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.clickable {  }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ContactDetailsItemPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        ContactDetailsItemView(
            "\uE98F",
            stringResource(id = R.string.contactus_address_title),
            "072222222",
            "test@text.com",
            null
        )
    }
}