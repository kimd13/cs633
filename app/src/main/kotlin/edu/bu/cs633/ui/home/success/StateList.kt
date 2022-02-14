package edu.bu.cs633.ui.home.success

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import edu.cs633.data.domain.VaccinationRecord

@Composable
fun StateList(
    vaccinationRecords: List<VaccinationRecord>
) {
    LazyColumn {
        items(vaccinationRecords) { record ->
            Text(
                text = record.location ?: "Not Available"
            )
        }
    }
}