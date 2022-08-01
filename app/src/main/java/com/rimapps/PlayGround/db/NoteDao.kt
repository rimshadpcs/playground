package com.rimapps.PlayGround.db

import androidx.room.*
import com.rimapps.PlayGround.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table ORDER BY note ASC")
    fun getAllNotes(): Flow<List<Note>>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAll()
}
