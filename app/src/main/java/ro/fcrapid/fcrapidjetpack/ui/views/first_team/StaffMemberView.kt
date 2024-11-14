package ro.fcrapid.fcrapidjetpack.ui.views.first_team

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.ui.theme.large
import ro.fcrapid.fcrapidjetpack.ui.theme.medium
import ro.fcrapid.fcrapidjetpack.ui.theme.mediumSmall
import ro.fcrapid.fcrapidjetpack.ui.theme.small
import ro.fcrapid.fcrapidjetpack.ui.theme.standard
import ro.fcrapid.fcrapidjetpack.ui.theme.xxSmall
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.VerticalSpacer


@Composable
fun StaffMemberView(name: String, role: String, birthDate: String?, icon: Int) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(xxSmall)
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .padding(standard)
        ) {
            IconSection(name, icon)
            VerticalSpacer(height = large)
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            VerticalSpacer(height = small)
            Text(
                text = role.uppercase(),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            VerticalSpacer(height = small)
            StatisticField("Data Nasterii", birthDate ?: "")

        }
    }
}

@Composable
private fun IconSection(
    name: String,
    icon: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            shape = RectangleShape,
            modifier = Modifier
                .width(180.dp)
                .height(240.dp)
                .background(MaterialTheme.colorScheme.primary, RectangleShape),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = name
            )
        }
    }
}


@Composable
private fun StatisticField(statisticName: String, statisticValue: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = mediumSmall, bottom = mediumSmall, end = mediumSmall)
        ) {
            Text(
                text = statisticName,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = statisticValue,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
        VerticalSpacer(height = medium)
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun StaffItemPreview() {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        StaffMemberView(
            name = "Horatiu Moldovan",
            role = "Portar",
            icon = R.drawable.player_31_moldovan,
            birthDate = "31"
        )
    }
}