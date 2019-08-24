package com.lognote.viewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.lognote.modal.Note;
import com.lognote.db.NoteRepository;
import java.util.List;
public class NoteViewModal extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>>  allNotes;
    public NoteViewModal(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
    public void insertNote(Note note){
        noteRepository.insertNote(note);
    }
    public void updateNote(Note note){
       noteRepository.updateNote(note);
    }
    public void deleteNote(Note note){
        noteRepository.deleteNote(note);
    }
    public void deleteAll(){
        noteRepository.deleteAll();
    }

}
