package com.example.leagueaccounttracker.DataBase

import kotlinx.coroutines.flow.Flow

class OfflineApp (private val DAO: DAOItem) : ProfileRep{
    override fun getAllProfileFacts(): Flow<List<Profile>> = DAO.getAllItems()

    override fun getProfById(id: Int): Flow<Profile> = DAO.getItem(id)

    override suspend fun addProfile(item: Profile) = DAO.insert(item)

    override suspend fun deleteProf(item: Profile) = DAO.delete(item)

    override suspend fun updateProf(item: Profile) = DAO.update(item)
}