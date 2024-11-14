package ro.fcrapid.fcrapidjetpack.ui.views.fixtures.standings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ro.fcrapid.fcrapidjetpack.ui.theme.xLarge


@Composable
fun LeagueHeaderItemView(
    headerTitlesTextStyle: TextStyle,
    headerTitlesBackGroundColor: Color,

) {

        Row(
            Modifier
                .fillMaxWidth()
                .background(headerTitlesBackGroundColor),
        ) {

                HeaderTableColumn(label = "#", headerTitlesTextStyle, Modifier.weight(2f))
                HeaderTableColumn(label = "Echipa", headerTitlesTextStyle, Modifier.weight(7f))
                HeaderTableColumn(label = "MJ", headerTitlesTextStyle, Modifier.weight(2f))
                HeaderTableColumn(label = "V", headerTitlesTextStyle, Modifier.weight(2f))
                HeaderTableColumn(label = "E", headerTitlesTextStyle, Modifier.weight(2f))
                HeaderTableColumn(label = "I", headerTitlesTextStyle, Modifier.weight(2f))
                HeaderTableColumn(label = "G", headerTitlesTextStyle, Modifier.weight(2f))
                HeaderTableColumn(label = "P", headerTitlesTextStyle, Modifier.weight(2f))
            }
    }


@Composable
private fun HeaderTableColumn(
    label: String,
    headerTitlesTextStyle: TextStyle,
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            style = headerTitlesTextStyle,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.background,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .height(xLarge)
                .wrapContentHeight(),
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TableHeaderComponentWithoutColumnDividersPreview() {


    LeagueHeaderItemView(

        headerTitlesTextStyle = MaterialTheme.typography.bodySmall,
        headerTitlesBackGroundColor = MaterialTheme.colorScheme.onSurfaceVariant,

    )
}

