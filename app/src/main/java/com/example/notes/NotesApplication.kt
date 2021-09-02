package com.example.notes

import android.app.Application

class NotesApplication: Application() {

    val database by lazy { NotesRoomDataBase.getDatabase(this) }
   val repository by lazy { NotesRepository(database.dao()) }
}

