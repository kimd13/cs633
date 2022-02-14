package edu.bu.cs633.ui.home.success

import androidx.compose.runtime.Composable
import edu.cs633.data.domain.VaccinationRecord

@Composable
fun SuccessScreen(
    vaccinationRecords: List<VaccinationRecord>
) {
    StateList(vaccinationRecords = vaccinationRecords)
}