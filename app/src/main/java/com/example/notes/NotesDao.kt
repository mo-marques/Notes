package com.example.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.notes.Notes as Notes

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes_table ORDER BY noteTitle ASC")
    fun getAlphabetizedWords(): Flow<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notes: Notes)

}