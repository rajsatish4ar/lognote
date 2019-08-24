package com.lognote.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.lognote.modal.Note;
import com.lognote.utils.NoteAsyncTask;

import java.util.List;

import static com.lognote.utils.Constants.DELETE;
import static com.lognote.utils.Constants.DELETE_ALL;
import static com.lognote.utils.Constants.INSERT;
import static com.lognote.utils.Constants.UPDATE;

public class NoteRepository {
    private NotesDAO notesDAO;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        notesDAO = database.notesDAO();
        allNotes = notesDAO.getAllNotes();
    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
    public void insertNote(Note note){
        new NoteAsyncTask(notesDAO,INSERT).execute(note);
    }
    public void updateNote(Note note){
        new NoteAsyncTask(notesDAO,UPDATE).execute(note);
    }
    public void deleteNote(Note note){
        new NoteAsyncTask(notesDAO,DELETE).execute(note);
    }
    public void deleteAll(){
        new NoteAsyncTask(notesDAO,DELETE_ALL).execute();
    }


}
