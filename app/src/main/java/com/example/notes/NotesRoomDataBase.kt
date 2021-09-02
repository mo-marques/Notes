package com.example.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesRoomDataBase : RoomDatabase() {

    abstract fun dao(): NotesDao

    companion object{
        @Volatile
        private var INSTANCE: NotesRoomDataBase? = null

        fun getDatabase(context: Context):NotesRoomDataBase{
            val instance = INSTANCE
            if (instance!=null){
                return instance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, NotesRoomDataBase::class.java, "notes_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }

    }
}