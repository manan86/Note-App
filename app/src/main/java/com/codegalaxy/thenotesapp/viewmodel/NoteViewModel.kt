package com.codegalaxy.thenotesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.codegalaxy.thenotesapp.model.Note
import com.codegalaxy.thenotesapp.model.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    private val repository: NoteRepository,
    app: Application
) : AndroidViewModel(app) {

    fun addNote(note : Note) =
        viewModelScope.launch {
            repository.insertNote(note)
        }

    fun deleteNote(note : Note) =
        viewModelScope.launch {
            repository.deleteNote(note)
        }

    fun updateNote(note : Note) =
        viewModelScope.launch {
            repository.updateNote(note)
        }

    fun getAllNOtes() = repository.getAllNotes()

    fun searchNote(query : String?) = repository.searchNote(query)
}

class NoteViewModelFactory( private val repository: NoteRepository, val app : Application,) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(repository,app) as T
    }
}