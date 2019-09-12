package com.lognote.modal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "log_table")
class LogNote {
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
    var title:String=""
    var description:String =""
    var createdAt:Long=0
    var updatedAt:Long=0

}