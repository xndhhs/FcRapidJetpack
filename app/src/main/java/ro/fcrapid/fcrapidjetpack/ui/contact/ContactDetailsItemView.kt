package ro.fcrapid.fcrapidjetpack.ui.contact

import android.content.res.Configuration
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.ui.theme.tyrian_font

@Composable
fun ContactDetailsItemView(contactSymbol: String, sectionTitle: String, sectionSubtitle: String) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 24.dp)
    ) {
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
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                SelectionContainer() {
                    Text(
                        text = sectionSubtitle,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
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
            stringResource(id = R.string.contactus_address_subtitle
            )
        )
    }
}