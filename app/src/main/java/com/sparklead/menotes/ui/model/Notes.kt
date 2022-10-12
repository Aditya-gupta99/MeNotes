package com.sparklead.menotes.ui.model

import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id :Int? = null,
    var Heading: String,
    var details : String,
    var date : String,

)
