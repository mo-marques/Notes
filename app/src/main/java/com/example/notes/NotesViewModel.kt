package com.example.notes

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NotesRepository): ViewModel() {

    val allNotes: LiveData<List<Notes>> = repository.allNotes.asLiveData()

    fun insert(notes: Notes){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(notes)
        }
    }

}class NoteViewModelFactory(private val repository: NotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
