package com.example.midterm.data.dao

import androidx.room.*
import com.example.midterm.data.models.Hobbies
import kotlinx.coroutines.flow.Flow

@Dao
interface HobbiesDao {
    @Query("SELECT * FROM hobbies")
    fun getAllHobbies(): Flow<List<Hobbies>>

    @Query("SELECT * FROM hobbies WHERE id = :id")
    suspend fun getHobbyById(id: Int): Hobbies?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHobby(hobby: Hobbies): Long

    @Update
    suspend fun updateHobby(hobby: Hobbies)

    @Delete
    suspend fun deleteHobby(hobby: Hobbies)
}