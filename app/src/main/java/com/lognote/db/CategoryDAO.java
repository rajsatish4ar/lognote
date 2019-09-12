package com.lognote.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lognote.modal.Category;
import com.lognote.modal.LogNote;

import java.util.List;


@Dao
public interface CategoryDAO {
    @Insert
    void add(Category category);
    @Update
    void update(Category category);
    @Delete
    void delete(Category category);
    @Query("DELETE FROM category_table")
    void deleteAll();

    @Query("SELECT * FROM category_table")
    LiveData<List<Category>> getAll();

    @Query("SELECT * FROM category_table")
    Category getDetails();

}
