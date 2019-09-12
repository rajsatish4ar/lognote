package com.lognote.modal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
class Category {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name:String= ""
    var color:String ="white"
    var timestamp:Long=0
}
