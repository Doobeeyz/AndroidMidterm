package com.example.midterm.data.repository

import com.example.midterm.data.dao.HobbiesDao
import com.example.midterm.data.models.Hobbies
import kotlinx.coroutines.flow.Flow

class HobbiesRepository(private val hobbiesDao: HobbiesDao) {
    val allHobbies: Flow<List<Hobbies>> = hobbiesDao.getAllHobbies()

    suspend fun getHobbyById(id: Int): Hobbies? {
        return hobbiesDao.getHobbyById(id)
    }

    suspend fun insertHobby(hobby: Hobbies): Long {
        return hobbiesDao.insertHobby(hobby)
    }

    suspend fun updateHobby(hobby: Hobbies) {
        hobbiesDao.updateHobby(hobby)
    }

    suspend fun deleteHobby(hobby: Hobbies) {
        hobbiesDao.deleteHobby(hobby)
    }
}