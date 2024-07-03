package ro.fcrapid.fcrapidjetpack.ui.contact

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            contentDescription = "Contact details image"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.contact_us_title_text),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Column(modifier = Modifier
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(16.dp))
            ContactDetailsItemView(
                ONLINE_ORDER_ITEM_SYMBOL,
                "Fotbal Club 1923 S.A. Shop online",
                "0752.152.237",
                "online@fcrapid.ro",
                null
            )
            ContactDetailsItemView(
                ONLINE_ORDER_ITEM_SYMBOL,
                "Bilete si Abonamente",
                "0731.968.631",
                "ticketing@fcrapid.ro",
                "Luni - Vineri: 9:00 - 18:00"
            )
            ContactDetailsItemView(
                SCHEDULE_ITEM_SYMBOL,
                "Program de lucru",
                null,
                null,
                "STADIONUL GIULEȘTI\n" +
                        "Luni – Vineri: 09:00 – 18:00\n" +
                        "Sâmbătă – Duminică: 10:00 – 15:00 \n\n" +
                        "GARA DE NORD\n" +
                        "Luni – Duminică: 10:00 – 18:00"
            )
            ContactDetailsItemView(
                ADDRESS_ITEM_SYMBOL,
                stringResource(id = R.string.contactus_address_title),
                null,
                null,
                stringResource(id = R.string.contactus_address_subtitle)
            )
            ContactDetailsItemView(
                ADDRESS_ITEM_SYMBOL,
                "Magazin de Prezentare",
                "0743.290.882",
                null,
                "Calea Giulești nr. 18, 060276, Sector 6, București, Superbet Arena"
            )
        }


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