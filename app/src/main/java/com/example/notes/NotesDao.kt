package com.example.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes_table ORDER BY noteTitle ASC")
    fun getAlphabetizedWords(): List<Notes>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Notes)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAll()
}