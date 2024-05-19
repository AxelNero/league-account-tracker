package com.example.leagueaccounttracker.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Profiles")
class Profile(
    @PrimaryKey(autoGenerate = true)
              val id: Int = 0,
              val profileName: String,
              val Password: String,)