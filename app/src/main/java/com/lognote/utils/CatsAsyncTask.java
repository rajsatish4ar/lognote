package com.lognote.utils;

import android.os.AsyncTask;

import com.lognote.db.CategoryDAO;
import com.lognote.db.LogDao;
import com.lognote.modal.Category;
import com.lognote.modal.LogNote;

import static com.lognote.utils.Constants.ADD_TEMP;
import static com.lognote.utils.Constants.DELETE;
import static com.lognote.utils.Constants.DELETE_ALL;
import static com.lognote.utils.Constants.INSERT;
import static com.lognote.utils.Constants.UPDATE;

public class CatsAsyncTask extends AsyncTask<Category, Void, Void> {
    private CategoryDAO catsDAO;
    private int type;
    public CatsAsyncTask(CategoryDAO catsDAO, int type) {
        this.catsDAO = catsDAO;
        this.type = type;
    }

    @Override
    protected Void doInBackground(Category... categories) {
        if(type==INSERT)
            catsDAO.add(categories[0]);
        else if (type==DELETE)
            catsDAO.delete(categories[0]);
        else if (type==UPDATE)
            catsDAO.update(categories[0]);
        else if (type==DELETE_ALL)
            catsDAO.delete(categories[0]);
        else if (type==ADD_TEMP){
            Category cat = new Category();
            catsDAO.add(cat);
        }

        return null;
    }
}
