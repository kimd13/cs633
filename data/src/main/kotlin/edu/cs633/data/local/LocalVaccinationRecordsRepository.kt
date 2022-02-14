package edu.cs633.data.local

import android.app.Application
import edu.bu.data.R
import edu.cs633.data.VaccinationRecordsRepository
import edu.cs633.data.domain.VaccinationRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.Charset
import javax.inject.Inject

class LocalVaccinationRecordsRepository @Inject constructor(
    private val application: Application
) : VaccinationRecordsRepository {

    override suspend fun get(): Flow<List<VaccinationRecord>> =
        flowOf(readVaccinationRecordsCsv())

    private fun readVaccinationRecordsCsv(): List<VaccinationRecord> {
        val vaccinationRecords = mutableListOf<VaccinationRecord>()
        val inputStream = application.resources.openRawResource(R.raw.us_state_vaccinations)
        val bufferReader = BufferedReader(
            InputStreamReader(inputStream, Charset.forName("UTF-8"))
        )

        // Starts with header, skip it
        var line: String? = bufferReader.readLine()
        line = bufferReader.readLine()

        while (line != null) {
            val tokens = line.split(",")
            val date: String = tokens[0] // cannot be null
            val location: String = tokens[1] // cannot be null
            val totalVaccinations: Float? = tokens[2].toFloatOrNull()
            val totalDistributed: Float? = tokens[3].toFloatOrNull()
            val peopleVaccinated: Float? = tokens[4].toFloatOrNull()
            val peopleFullyVaccinated: Float? = tokens[7].toFloatOrNull()
            val dailyVaccinations: Float? = tokens[11].toFloatOrNull()
            val totalBoosters: Int? = tokens[14].toIntOrNull()
            vaccinationRecords.add(
                VaccinationRecord(
                    date,
                    location,
                    totalVaccinations,
                    totalDistributed,
                    peopleVaccinated,
                    peopleFullyVaccinated,
                    dailyVaccinations,
                    totalBoosters
                )
            )
            line = bufferReader.readLine()
        }

        return vaccinationRecords
    }
}