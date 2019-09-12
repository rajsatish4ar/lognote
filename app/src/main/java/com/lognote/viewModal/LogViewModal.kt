package com.lognote.viewModal
import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.databinding.Bindable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lognote.db.LogRepository
import com.lognote.modal.Category
import com.lognote.modal.LogNote

class LogViewModal(application: Application) : AndroidViewModel(application){

    @Bindable
    var title=""
    @Bindable
    var description=""
    var allLogs:LiveData<List<LogNote>>
    private val logRepository: LogRepository = LogRepository(application)

    init {
        allLogs = logRepository.allLogs

    }

    fun getAllNotes(): LiveData<List<LogNote>> {
        return allLogs
    }

    fun insertNote(logNote: LogNote) {
        logRepository.insertLog(logNote)
    }

    fun updateNote(logNote: LogNote) {
        logRepository.updateLog(logNote)
    }

    fun deleteNote(logNote: LogNote) {
        logRepository.deleteLog(logNote)
    }

    fun deleteAll() {
        logRepository.deleteAllLogs()
    }


}

