package com.example.leagueaccounttracker.DataBase

import kotlinx.coroutines.flow.Flow

interface ProfileRep {
    fun getAllProfileFacts(): Flow<List<Profile>>

    fun getProfById(id: Int) : Flow<Profile>

    suspend fun addProfile(prof: Profile)

    suspend fun deleteProf(prof: Profile)

    suspend fun updateProf(ProfilesYes: Profile)
}