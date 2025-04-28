package com.example.midterm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.midterm.data.dao.HobbiesDao
import com.example.midterm.data.models.Hobbies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Hobbies::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {
    abstract fun hobbiesDao(): HobbiesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        fun getDatabase(context: Context): AppDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "hobbies_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val hemaHobby = Hobbies(
                                title = "HEMA",
                                desc = "Historical European Martial Arts - historical European martial arts, based on the European martial tradition, which is being revived in our time on the basis of ancient manuscripts on fencing."
                            )

                            CoroutineScope(Dispatchers.IO).launch {
                                INSTANCE?.hobbiesDao()?.insertHobby(hemaHobby)
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}