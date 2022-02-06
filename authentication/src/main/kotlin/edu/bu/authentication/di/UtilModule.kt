package edu.bu.authentication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.bu.authentication.util.AlertManager
import edu.bu.authentication.util.ToastAlertManager

@Module
@InstallIn(SingletonComponent::class)
interface UtilModule {

    @Binds
    fun bindAlertManager(alertManager: ToastAlertManager): AlertManager
}