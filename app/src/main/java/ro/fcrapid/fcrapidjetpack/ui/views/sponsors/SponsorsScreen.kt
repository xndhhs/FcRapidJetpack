package ro.fcrapid.fcrapidjetpack.ui.views.sponsors

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.fcrapid.fcrapidjetpack.R
import ro.fcrapid.fcrapidjetpack.models.SponsorModel

@Composable
fun SponsorsScreen(sponsorList: List<SponsorModel>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        userScrollEnabled = true,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalItemSpacing = 2.dp,
        contentPadding = PaddingValues(8.dp),
        flingBehavior = ScrollableDefaults.flingBehavior()
    ) {
        sponsorList.forEach {
            item { SponsorSection(it) }
        }
    }
}

@Composable
fun SponsorSection(sponsorModel: SponsorModel) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background, RectangleShape)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = sponsorModel.imageId),
            contentDescription = sponsorModel.title
        )
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SponsorScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        SponsorsScreen(
            sponsorList = listOf(
                SponsorModel("Superbet - partener principal", R.drawable.ic_sponsor_superbet),
                SponsorModel("Mobexpert - partener secundar", R.drawable.ic_sponsor_mobexpert),
                SponsorModel("Ferroli", R.drawable.ic_sponsor_ferolli),
                SponsorModel("DSC", R.drawable.ic_sponsor_dsc),
                SponsorModel("Saormeria Baneasa", R.drawable.ic_sponsor_baneasa),
                SponsorModel("Neakaisa", R.drawable.ic_sponsor_neakaisa),
                SponsorModel("Torry", R.drawable.ic_sponsor_torry),
                SponsorModel("Tarsin", R.drawable.ic_sponsor_tarsin),
                SponsorModel("Skol", R.drawable.ic_sponsor_skol),
                SponsorModel("Fiterman", R.drawable.ic_sponsor_fiterman),
                SponsorModel("Ghita", R.drawable.ic_sponsor_ghita),
                SponsorModel("SIXT", R.drawable.ic_sponsor_sixt),
                SponsorModel("Sergentu", R.drawable.ic_sponsor_sergentu),
                SponsorModel("Acumen", R.drawable.ic_sponsor_acumen),
                SponsorModel("Ghetarie", R.drawable.ic_sponsor_ghetarie),
                SponsorModel("Grande Natura", R.drawable.ic_sponsor_gnatura),
                SponsorModel("Centrokinetic", R.drawable.ic_sponsor_centrokinetic),
                SponsorModel("Rompex", R.drawable.ic_sponsor_rompex),
            )
        )
    }
}