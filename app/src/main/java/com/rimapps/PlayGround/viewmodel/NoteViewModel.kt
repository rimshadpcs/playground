package com.rimapps.PlayGround.viewmodel

import androidx.lifecycle.*
import com.rimapps.PlayGround.model.Note
import com.rimapps.PlayGround.repository.NoteRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException


class NoteViewModel(private val repository: NoteRepository): ViewModel(){

val allNotes: LiveData<List<Note>> = repository.allNotes.asLiveData()

    /*Launching new coroutine to insert the data in a non blocking way*/

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

}

class NoteViewModelFactory(private val noteRepository: NoteRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){

            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(noteRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}