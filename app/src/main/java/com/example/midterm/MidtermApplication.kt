package com.example.midterm

import android.app.Application
import com.example.midterm.data.database.AppDB
import com.example.midterm.data.repository.HobbiesRepository

class MidtermApplication: Application() {
    val database by lazy { AppDB.getDatabase(this) }
    val repository by lazy { HobbiesRepository (database.hobbiesDao())}
}