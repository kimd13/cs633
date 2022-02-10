package edu.cs633.data

import edu.cs633.data.domain.VaccinationRecord
import kotlinx.coroutines.flow.Flow

interface VaccinationRecordsRepository {
    fun get(): Flow<List<VaccinationRecord>>
}