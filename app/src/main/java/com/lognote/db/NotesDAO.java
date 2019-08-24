package com.lognote.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lognote.modal.Note;

import java.util.List;

@Dao
public interface NotesDAO {
    @Insert
    void insert(Note note);
    @Update
    void update(Note note);
    @Delete
    void delete(Note note);
    @Query("DELETE FROM notes_table")
    void deleteAllNotes();

    @Query("SELECT * FROM notes_table")
    LiveData<List<Note>> getAllNotes();
    @Query("SELECT * FROM notes_table")
    Note getNoteDetails();

}
