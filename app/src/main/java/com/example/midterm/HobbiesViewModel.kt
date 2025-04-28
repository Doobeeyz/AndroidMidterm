package com.example.midterm.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.midterm.data.models.Hobbies
import com.example.midterm.data.repository.HobbiesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HobbiesViewModel(private val repository: HobbiesRepository) : ViewModel() {

    val allHobbies: StateFlow<List<Hobbies>> = repository.allHobbies
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addHobby(title: String, desc: String) {
        viewModelScope.launch {
            val hobby = Hobbies(title = title, desc = desc)
            repository.insertHobby(hobby)
        }
    }

    fun updateHobby(hobby: Hobbies) {
        viewModelScope.launch {
            repository.updateHobby(hobby)
        }
    }

    fun deleteHobby(hobby: Hobbies) {
        viewModelScope.launch {
            repository.deleteHobby(hobby)
        }
    }
}

class HobbiesViewModelFactory(private val repository: HobbiesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HobbiesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HobbiesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}