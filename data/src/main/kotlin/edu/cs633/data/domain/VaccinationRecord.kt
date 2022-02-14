package edu.cs633.data.domain

data class VaccinationRecord(
    val date: String?,
    val location: String?,
    val totalVaccinations: Float?,
    val totalDistributed: Float?,
    val peopleVaccinated: Float?,
    val peopleFullyVaccinated: Float?,
    val dailyVaccinations: Float?,
    val totalBoosters: Int?
)