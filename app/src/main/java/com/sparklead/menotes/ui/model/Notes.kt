package com.sparklead.menotes.ui.model

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Notes")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id :Int? = null,
    var Heading: String,
    var details : String,
    var date : String,
):Parcelable
