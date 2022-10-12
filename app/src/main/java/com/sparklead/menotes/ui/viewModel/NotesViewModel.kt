package com.sparklead.menotes.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sparklead.menotes.ui.database.NotesDatabase
import com.sparklead.menotes.ui.model.Notes
import com.sparklead.menotes.ui.repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val repository : NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes){
        repository.insertNotes(notes)
    }

    fun getNotes() : LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNotes(id: Int){
        repository.deleteNotes(id)
    }

    fun update(notes: Notes){
        repository.updateNotes(notes)
    }

}