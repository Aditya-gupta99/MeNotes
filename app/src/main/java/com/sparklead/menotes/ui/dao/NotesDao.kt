package com.sparklead.menotes.ui.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sparklead.menotes.ui.model.Notes

@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes():LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("DELETE FROM Notes WHERE id =:id")
    fun deleteNotes(id:Int)

    @Update
    fun updateNotes(notes: Notes)
}