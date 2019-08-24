package com.lognote.modal

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_table")
class Note {
    @PrimaryKey(autoGenerate = true)
    var double: Int = 0
    var title: String? = null
    var subTitle: String? = null
    var timeStamp: Double = 0.toDouble()
    var body: String? = null

}
