package edu.cs633.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.cs633.data.VaccinationRecordsRepository
import edu.cs633.data.local.LocalVaccinationRecordsRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindVaccinationRecordsRepository(
        vaccinationRecordsRecordsRepository: LocalVaccinationRecordsRepository
    ): VaccinationRecordsRepository
}