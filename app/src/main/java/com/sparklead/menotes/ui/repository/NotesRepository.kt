package com.sparklead.menotes.ui.repository

import androidx.lifecycle.LiveData
import com.sparklead.menotes.ui.dao.NotesDao
import com.sparklead.menotes.ui.model.Notes

class NotesRepository(val dao : NotesDao) {

    fun getAllNotes() :LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }

}