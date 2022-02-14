package edu.bu.cs633.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import edu.bu.cs633.ui.home.failure.FailureScreen
import edu.bu.cs633.ui.home.loading.LoadingScreen
import edu.bu.cs633.ui.home.model.NetworkData
import edu.bu.cs633.ui.home.success.SuccessScreen
import edu.cs633.data.domain.VaccinationRecord

@Composable
fun HomeScreen(
    navigateToAuthentication: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val vaccinationRecords by remember(homeViewModel) {
        homeViewModel.vaccinationRecords
    }.collectAsState()

    when (vaccinationRecords) {
        is NetworkData.Success<List<VaccinationRecord>> -> {
            SuccessScreen(
                homeViewModel,
                (vaccinationRecords as NetworkData.Success<List<VaccinationRecord>>).data
            )
        }
        is NetworkData.Loading -> LoadingScreen()
        is NetworkData.Failure -> FailureScreen()
    }
}