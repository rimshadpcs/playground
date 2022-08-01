package com.rimapps.PlayGround

import android.app.Application
import com.rimapps.PlayGround.db.NoteDataBase
import com.rimapps.PlayGround.repository.NoteRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class BaseApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { NoteDataBase.getDatabase(this, applicationScope) }
    val repository by lazy { NoteRepository(database.noteDao()) }

}