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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.common.TyrianSymbols.RIGHT_ARROW
import ro.fcrapid.fcrapidjetpack.ui.theme.iconXXLarge
import ro.fcrapid.fcrapidjetpack.ui.theme.large
import ro.fcrapid.fcrapidjetpack.ui.theme.medium
import ro.fcrapid.fcrapidjetpack.ui.theme.mediumSmall
import ro.fcrapid.fcrapidjetpack.ui.theme.rapid_font
import ro.fcrapid.fcrapidjetpack.ui.theme.small
import ro.fcrapid.fcrapidjetpack.ui.theme.standard
import ro.fcrapid.fcrapidjetpack.ui.theme.tyrian_font
import ro.fcrapid.fcrapidjetpack.ui.theme.xLarge
import ro.fcrapid.fcrapidjetpack.ui.theme.xxSmall
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.HorizontalSpacer
import ro.fcrapid.fcrapidjetpack.ui.views.shared_components.VerticalSpacer


@Composable
fun TeamMemberView(name: String, role: String, shirtNumber: String?, icon: Int) {
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
            MainInfoSection(shirtNumber, name, role, icon)
            VerticalSpacer(height = large)
            Text(
                text = "SEZON 2024-25",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.outline
            )
            VerticalSpacer(height = small)
            StatisticField("Apperances", "13")
            StatisticField("Saves Made", "28")
            StatisticField("Clean Sheets", "8")
            VerticalSpacer(height = large)
            Row(
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Profil Complet".uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = RIGHT_ARROW,
                    fontFamily = tyrian_font,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                )

            }
        }
    }
}

@Composable
private fun MainInfoSection(
    shirtNumber: String?,
    name: String,
    role: String,
    icon: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        Column {
            if (shirtNumber != null) {
                Text(
                    text = shirtNumber,
                    fontFamily = rapid_font,
                    fontSize = iconXXLarge,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
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
        }
        HorizontalSpacer(width = xLarge)
        Card(
            shape = RectangleShape,
            modifier = Modifier
                .width(70.dp)
                .height(100.dp)
                .background(MaterialTheme.colorScheme.background, RectangleShape),
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
fun PlayerItemPreview() {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        TeamMemberView(
            name = "Horatiu Moldovan",
            role = "Portar",
            icon = R.drawable.player_31_moldovan,
            shirtNumber = "31"
        )
    }
}