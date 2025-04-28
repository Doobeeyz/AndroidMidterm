package com.example.midterm.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hobbies(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val desc: String
)
