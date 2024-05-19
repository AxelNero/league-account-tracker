package com.example.leagueaccounttracker.DataBase

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.leagueaccounttracker.DataBase.Profile
import com.example.leagueaccounttracker.DataBase.ProfileRep
import java.text.NumberFormat

class ProfileEntryToViewModel(private val itemsRepository: ProfileRep) : ViewModel()  {
        var profileUiState by mutableStateOf(ProfileUiState())
            private set
        fun updateUiState(profileDetails: ProfileDetails) {
            profileUiState =
                ProfileUiState(profileDetails = profileDetails, isEntryValid = validateInput(profileDetails))
        }

        private fun validateInput(uiState: ProfileDetails = profileUiState.profileDetails): Boolean {
            return with(uiState) {
                profileName.isNotBlank() && Password.isNotBlank()
            }
        }
        suspend fun saveItem() {
            if (validateInput()) {
                itemsRepository.addProfile(profileUiState.profileDetails.toProfile())
            }
        }
    }
    data class ProfileUiState(
        val profileDetails: ProfileDetails = ProfileDetails(),
        val isEntryValid: Boolean = false
    )

    data class ProfileDetails(
        val id: Int = 0,
        val profileName: String = "",
        val Password: String = "",
        )

    fun ProfileDetails.toProfile(): Profile = Profile(
        id = id,
        profileName = profileName,
        Password = Password,
        )
    fun Profile.toProfileUiStates(isEntryValid: Boolean = false): ProfileUiState = ProfileUiState(
        profileDetails = this.toProfileDetails(),
        isEntryValid = isEntryValid
    )
    fun Profile.toProfileDetails(): ProfileDetails = ProfileDetails(
        id = id,
        profileName = profileName,
        Password = Password
    )