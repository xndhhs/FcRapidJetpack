package ro.fcrapid.fcrapidjetpack.ui.views.first_team

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.ui.theme.rapid_font


@Composable
fun TeamMemberView(name: String, role: String, shirtNumber: String?, icon: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = CenterVertically
        ) {
            Row(verticalAlignment = CenterVertically) {
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
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = name.uppercase(),
                        style = MaterialTheme.typography.titleSmall,
                    )
                    Text(
                        text = role,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
            if (shirtNumber != null) {
                Text(
                    text = shirtNumber.toString(),
                    fontFamily = rapid_font,
                    fontSize = 64.sp,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PlayerItemPreview() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    ) {
        TeamMemberView(
            name = "Horatiu Moldovan",
            role = "Portar",
            icon = R.drawable.player_31_moldovan,
            shirtNumber = "31",

            )
    }
}