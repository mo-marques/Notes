package com.example.notes

import kotlinx.coroutines.flow.Flow

class NotesRepository(private val dao: NotesDao) {

    val allNotes: Flow<List<Notes>> = dao.getAlphabetizedWords()

    suspend fun insert(notes: Notes){
        dao.insert(notes)
        
    }
}