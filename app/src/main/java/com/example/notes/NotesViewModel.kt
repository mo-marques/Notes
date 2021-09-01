package com.example.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NotesRepository): ViewModel() {

    val allNotes: LiveData<List<Notes>> = repository.allNotes.asLiveData()

    fun insert(notes: Notes){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(notes)
        }
    }

}