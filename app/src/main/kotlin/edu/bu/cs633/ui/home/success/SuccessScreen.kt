package edu.bu.cs633.ui.home.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.cs633.data.domain.VaccinationRecord

@Composable
fun SuccessScreen(
    vaccinationRecords: List<VaccinationRecord>
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        SearchBar(query = "", onQueryChanged = {})
        StateList(vaccinationRecords = vaccinationRecords)
    }
}