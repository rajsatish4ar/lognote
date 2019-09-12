package com.lognote.viewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lognote.db.CatsRepository;
import com.lognote.db.LogRepository;
import com.lognote.modal.Category;
import com.lognote.modal.LogNote;

import java.util.List;
public class CatsViewModal extends ViewModel {

    private CatsRepository catsRepository;
    private LiveData<List<Category>>  allNotes;
    public CatsViewModal(@NonNull Application application) {
        catsRepository = new CatsRepository(application);
        allNotes = catsRepository.getAllLogs();
    }

    public LiveData<List<Category>> getAllNotes(){
        return allNotes;
    }
    public void insertNote(Category category){
        catsRepository.insert(category);
    }
    public void updateNote(Category category){
        catsRepository.update(category);
    }
    public void deleteNote(Category category){
        catsRepository.delete(category);
    }
    public void deleteAll(){
        catsRepository.deleteAll();
    }

}
