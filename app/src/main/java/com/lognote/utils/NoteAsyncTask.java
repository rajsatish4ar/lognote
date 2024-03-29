package com.lognote.utils;
import android.os.AsyncTask;
import com.lognote.db.LogDao;
import com.lognote.modal.LogNote;

import static com.lognote.utils.Constants.ADD_TEMP;
import static com.lognote.utils.Constants.DELETE;
import static com.lognote.utils.Constants.DELETE_ALL;
import static com.lognote.utils.Constants.INSERT;
import static com.lognote.utils.Constants.UPDATE;
public class NoteAsyncTask extends AsyncTask<LogNote, Void, Void> {
    private LogDao logDao;
    private int type;
    public NoteAsyncTask(LogDao logDao, int type) {
        this.logDao = logDao;
        this.type = type;
    }

    @Override
    protected Void doInBackground(LogNote... logs) {
        if(type==INSERT)
            logDao.add(logs[0]);
        else if (type==DELETE)
            logDao.delete(logs[0]);
        else if (type==UPDATE)
            logDao.update(logs[0]);
        else if (type==DELETE_ALL)
            logDao.delete(logs[0]);
        else if (type==ADD_TEMP){
            LogNote log = new LogNote();
            log.setTitle("LogNote Demo");
            log.setDescription("LogNote is an APP to store logs and perform multiple query based on it!");
            logDao.add(log);
        }

        return null;
    }
}
