package com.example.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesRoomDataBase : RoomDatabase() {

    abstract fun dao(): NotesDao

    private class NotesDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database -> scope.launch {
                var dao = database.dao()

                suspend fun populateDatabase(notesDao: NotesDao) {
                    notesDao.deleteAll()


                    var notes = Notes(0,"Title", "Description")
                    notesDao.insert(notes)



                }

            }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: NotesRoomDataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ):NotesRoomDataBase{
                return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesRoomDataBase::class.java,
                    "notes_database"
                )
                    .addCallback(NotesDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                 instance
            }
        }

    }
}