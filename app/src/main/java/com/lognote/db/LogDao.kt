package com.lognote.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lognote.modal.LogNote

@Dao
interface LogDao {

    @get:Query("SELECT * FROM log_table")
    val allLogs : LiveData<List<LogNote>>
    @Insert
    fun add(log:LogNote)
    @Update
    fun update(log:LogNote)
    @Delete
    fun delete(log:LogNote)

}