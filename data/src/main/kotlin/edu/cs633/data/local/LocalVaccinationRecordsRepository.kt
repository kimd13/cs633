package edu.cs633.data.local

import edu.cs633.data.VaccinationRecordsRepository
import edu.cs633.data.domain.VaccinationRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class LocalVaccinationRecordsRepository @Inject constructor(): VaccinationRecordsRepository {

    override fun get(): Flow<List<VaccinationRecord>> {
        return emptyFlow()
    }
}