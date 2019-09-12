package com.lognote.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lognote.modal.Category;
import com.lognote.modal.LogNote;
import com.lognote.utils.NoteAsyncTask;

import java.util.List;

import static com.lognote.utils.Constants.DELETE;
import static com.lognote.utils.Constants.DELETE_ALL;
import static com.lognote.utils.Constants.INSERT;
import static com.lognote.utils.Constants.UPDATE;

public class LogRepository {
    private LogDao logDao;
    private LiveData<List<LogNote>> allNotes;
    public LogRepository(Application application) {
        LogsDatabase database = LogsDatabase.getInstance(application);
        logDao = database.logDao();
        allNotes = logDao.getAllLogs();
    }

    public LiveData<List<LogNote>> getAllLogs(){
        return allNotes;
    }
    public void insertLog(LogNote log){
        new NoteAsyncTask(logDao,INSERT).execute(log);
    }
    public void updateLog(LogNote log){
        new NoteAsyncTask(logDao,UPDATE).execute(log);
    }
    public void deleteLog(LogNote log){
        new NoteAsyncTask(logDao,DELETE).execute(log);
    }
    public void deleteAllLogs(){
        new NoteAsyncTask(logDao,DELETE_ALL).execute();
    }


}
