package com.example.notes

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NotesApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { NotesRoomDataBase.getDatabase(this, applicationScope) }
   val repository by lazy { NotesRepository(database.dao()) }
}
