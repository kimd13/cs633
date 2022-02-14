package edu.bu.cs633.ui.home.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import edu.bu.cs633.ui.home.HomeViewModel
import edu.cs633.data.domain.VaccinationRecord

@Composable
fun SuccessScreen(
    homeViewModel: HomeViewModel,
    vaccinationRecords: List<VaccinationRecord>
) {
    val query by remember { homeViewModel.query }.collectAsState()
    val options by remember { homeViewModel.filteringOptions }.collectAsState()

    Column(
        Modifier.fillMaxSize()
    ) {
        SearchBar(
            query = query,
            onQueryChanged = { homeViewModel.changeQuery(it) },
            options = options
        )
        StateList(vaccinationRecords = vaccinationRecords)
    }
}