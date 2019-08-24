package com.lognote.utils;

import android.os.AsyncTask;

import com.lognote.modal.Note;
import com.lognote.db.NotesDAO;

import static com.lognote.utils.Constants.ADD_TEMP_NOTES;
import static com.lognote.utils.Constants.DELETE;
import static com.lognote.utils.Constants.DELETE_ALL;
import static com.lognote.utils.Constants.INSERT;
import static com.lognote.utils.Constants.UPDATE;

public class NoteAsyncTask extends AsyncTask<Note, Void, Void> {
    private NotesDAO notesDAO;
    private int type;
    public NoteAsyncTask(NotesDAO notesDAO,int type) {
        this.notesDAO = notesDAO;
        this.type = type;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        if(type==INSERT)
            notesDAO.insert(notes[0]);
        else if (type==DELETE)
         notesDAO.delete(notes[0]);
        else if (type==UPDATE)
            notesDAO.update(notes[0]);
        else if (type==DELETE_ALL)
            notesDAO.deleteAllNotes();
        else if (type==ADD_TEMP_NOTES){
            Note note = new Note();
            note.setTitle("Lorem Ipsum Generator");
            note.setBody("Generate Lorem Ipsum placeholder text. Select the number of characters, words, sentences or paragraphs, and hit generate!");
            notesDAO.insert(note);
            note = new Note();
            note.setTitle("Parturient montes nascetur ridiculus mus ");
            note.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
            notesDAO.insert(note);
            note = new Note();
            note.setTitle("Ultrices mi tempus imperdiet nulla");
            note.setBody("Generate Lorem Ipsum placeholder text. Select the number of characters, words, sentences or paragraphs, and hit generate!");
            notesDAO.insert(note);

        }

        return null;
    }
}
