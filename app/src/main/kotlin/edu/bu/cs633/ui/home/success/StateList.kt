package edu.bu.cs633.ui.home.success

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import edu.cs633.data.domain.VaccinationRecord

@Composable
fun StateList(
    vaccinationRecords: List<VaccinationRecord>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        items(vaccinationRecords) { record ->
            StateCard(vaccinationRecord = record)
        }
    }
}