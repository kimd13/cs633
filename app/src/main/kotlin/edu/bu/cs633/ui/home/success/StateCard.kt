package edu.bu.cs633.ui.home.success

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import edu.cs633.data.domain.VaccinationRecord

@Composable
fun StateCard(vaccinationRecord: VaccinationRecord) {
    val na = "N/A"
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            vaccinationRecord.apply {
                Text(
                    text = location ?: na,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
                Text(text = "Total vaccinations: ${totalVaccinations ?: na}")
                Text(text = "Total distributed: ${totalDistributed ?: na}")
                Text(text = "People vaccinated: ${peopleVaccinated ?: na}")
                Text(text = "People fully vaccinated: ${peopleFullyVaccinated ?: na}")
                Text(text = "Daily vaccinations: ${dailyVaccinations ?: na}")
                Text(text = "Total boosters: ${totalBoosters ?: na}")
            }
        }
    }
}