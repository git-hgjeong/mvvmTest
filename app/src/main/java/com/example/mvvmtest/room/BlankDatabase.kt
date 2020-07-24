package com.example.mvvmtest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(BlankEntity::class), version = 1, exportSchema = false)
abstract class BlankDatabase : RoomDatabase() {
    abstract fun blankDao() : BlankDao

    companion object {
        @Volatile
        private var INSTANCE : BlankDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ) : BlankDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance : BlankDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    BlankDatabase::class.java,
                    "blank_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}