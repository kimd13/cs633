package edu.bu.cs633.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.bu.cs633.ui.home.model.NetworkData
import edu.bu.cs633.ui.home.success.SortOption
import edu.bu.cs633.ui.home.success.SortOption.*
import edu.cs633.data.VaccinationRecordsRepository
import edu.cs633.data.domain.VaccinationRecord
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val vaccinationRecordsRepository: VaccinationRecordsRepository
) : ViewModel() {

    private val _vaccinationRecords: MutableStateFlow<NetworkData<List<VaccinationRecord>>> =
        MutableStateFlow(NetworkData.Loading)
    val vaccinationRecords: StateFlow<NetworkData<List<VaccinationRecord>>> = _vaccinationRecords

    private lateinit var vaccinationRecordsCopy: List<VaccinationRecord>
    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val defaultOption = LOCATION
    private val _option: MutableStateFlow<SortOption> = MutableStateFlow(defaultOption)
    val option: StateFlow<SortOption> = _option
    private val _sortOptions: MutableStateFlow<List<SortOption>> = MutableStateFlow(
        listOf(
            LOCATION,
            TOTAL_VACCINATIONS,
            TOTAL_DISTRIBUTED,
            PEOPLE_VACCINATED,
            PEOPLE_FULLY_VACCINATED,
            DAILY_VACCINATIONS,
            TOTAL_BOOSTERS
        )
    )
    val sortOptions: StateFlow<List<SortOption>> = _sortOptions

    init {
        viewModelScope.launch {
            vaccinationRecordsRepository.get().collect {
                val filteredData = filterLatestStateData(it)
                vaccinationRecordsCopy = filteredData
                _vaccinationRecords.emit(NetworkData.Success(filteredData))
            }
        }
    }

    fun changeQuery(newQuery: String) {
        _option.value = defaultOption
        _query.value = newQuery
        val replacement = vaccinationRecordsCopy.filter {
            it.location.lowercase().contains(newQuery.lowercase())
        }
        _vaccinationRecords.value = NetworkData.Success(replacement)
    }

    fun changeOption(newOption: SortOption) {
        _query.value = ""
        _option.value = newOption
        val replacement = when (newOption) {
            LOCATION -> vaccinationRecordsCopy.sortedBy { it.location }
            TOTAL_VACCINATIONS -> vaccinationRecordsCopy.sortedWith(
                compareBy(nullsLast()) { it.totalVaccinations }
            )
            TOTAL_DISTRIBUTED -> vaccinationRecordsCopy.sortedWith(
                compareBy(nullsLast()) { it.totalDistributed }
            )
            PEOPLE_VACCINATED -> vaccinationRecordsCopy.sortedWith(
                compareBy(nullsLast()) { it.peopleVaccinated }
            )
            PEOPLE_FULLY_VACCINATED -> vaccinationRecordsCopy.sortedWith(
                compareBy(nullsLast()) { it.peopleFullyVaccinated }
            )
            DAILY_VACCINATIONS -> vaccinationRecordsCopy.sortedWith(
                compareBy(nullsLast()) { it.dailyVaccinations }
            )
            TOTAL_BOOSTERS -> vaccinationRecordsCopy.sortedWith(
                compareBy(nullsLast()) { it.totalBoosters }
            )
        }
        _vaccinationRecords.value = NetworkData.Success(replacement)
    }

    private fun filterLatestStateData(
        vaccinationRecords: List<VaccinationRecord>
    ): List<VaccinationRecord> {
        val uniqueStateMap: HashMap<String, VaccinationRecord> = hashMapOf()
        vaccinationRecords.forEach { record ->
            uniqueStateMap[record.location] = record
        }
        return uniqueStateMap
            .map { it.value }
            .sortedBy { it.location }
    }
}