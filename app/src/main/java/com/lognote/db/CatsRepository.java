package com.lognote.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lognote.modal.Category;
import com.lognote.modal.LogNote;
import com.lognote.utils.CatsAsyncTask;
import com.lognote.utils.NoteAsyncTask;

import java.util.List;

import static com.lognote.utils.Constants.DELETE;
import static com.lognote.utils.Constants.DELETE_ALL;
import static com.lognote.utils.Constants.INSERT;
import static com.lognote.utils.Constants.UPDATE;

public class CatsRepository {

    private CategoryDAO catsDao;
    private LiveData<List<Category>> allCats;
    public CatsRepository(Application application) {
        LogsDatabase database = LogsDatabase.getInstance(application);
        catsDao =database.catDao();
        allCats = catsDao.getAll();
    }

    public LiveData<List<Category>> getAllLogs(){
        return allCats;
    }
    public void insert(Category category){
        new CatsAsyncTask(catsDao,INSERT).execute(category);
    }
    public void update(Category category){
        new CatsAsyncTask(catsDao,UPDATE).execute(category);
    }
    public void delete(Category category){
        new CatsAsyncTask(catsDao,DELETE).execute(category);
    }
    public void deleteAll(){
        new CatsAsyncTask(catsDao,DELETE_ALL).execute();
    }


}
