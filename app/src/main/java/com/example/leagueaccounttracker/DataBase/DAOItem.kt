package com.example.leagueaccounttracker.DataBase

import kotlinx.coroutines.flow.Flow
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
@Dao
interface DAOItem {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profile: Profile)

    @Update
    suspend fun update(profile: Profile)

    @Delete
    suspend fun delete(profile: Profile)

    @Query("SELECT * from Profiles WHERE id = :id")
    fun getItem(id: Int): Flow<Profile>

    @Query("SELECT * from Profiles ORDER BY profileName ASC")
    fun getAllItems(): Flow<List<Profile>>
}