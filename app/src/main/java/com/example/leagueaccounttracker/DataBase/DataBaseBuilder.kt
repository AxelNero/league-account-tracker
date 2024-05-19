package com.example.leagueaccounttracker.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Profile::class], version = 1, exportSchema = false)
abstract class DataBaseBuilder : RoomDatabase(){
        abstract fun DAOleague(): DAOItem
        companion object {
            @Volatile
            private var Instance: DataBaseBuilder? = null

            fun getDatabase(context: Context): DataBaseBuilder {
                // if the Instance is not null, return it, otherwise create a new database instance.
                return Instance ?: synchronized(this) {
                    Room.databaseBuilder(context, DataBaseBuilder::class.java, "item_database")
                        .build()
                        .also { Instance = it }
                }
            }

    }
}