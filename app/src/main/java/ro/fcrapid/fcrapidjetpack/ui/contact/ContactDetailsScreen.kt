package ro.fcrapid.fcrapidjetpack.ui.contact

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.fcrapid.fcrapidjetpack.R

const val ADDRESS_ITEM_SYMBOL = "\uE98F"
const val SCHEDULE_ITEM_SYMBOL = "\uE95F"
const val ONLINE_ORDER_ITEM_SYMBOL = "\uE9CF"


@Composable
fun ContactDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto_giulesti2),
            contentDescription = "Contact details image",
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.fc_rapid_bucuresti_logo),
                contentDescription = "Rapid Logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = stringResource(id = R.string.contact_us_title_text),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        ContactDetailsItemView(
            ADDRESS_ITEM_SYMBOL,
            stringResource(id = R.string.contactus_address_title),
            stringResource(id = R.string.contactus_address_subtitle)
        )
        ContactDetailsItemView(
            SCHEDULE_ITEM_SYMBOL,
            "Program de lucru",
            "Luni – Vineri: 09:00 – 18:00\n" +
                    "Sâmbătă: închis\n" +
                    "Duminică: închis"
        )
        ContactDetailsItemView(
            ONLINE_ORDER_ITEM_SYMBOL,
            "Comenzi Online",
            "0751.298.089\n" +
                    "0752.152.237\n" +
                    "online@fcrapid.ro"
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ContactDetailsScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        ContactDetailsScreen()
    }
}