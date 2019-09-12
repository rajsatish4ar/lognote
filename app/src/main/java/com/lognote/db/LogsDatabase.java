package com.lognote.db;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.lognote.modal.Category;
import com.lognote.modal.LogNote;
import com.lognote.utils.NoteAsyncTask;

import static com.lognote.utils.Constants.ADD_TEMP;

@Database(entities = {LogNote.class, Category.class}, version = 1)
public abstract class LogsDatabase extends RoomDatabase {
    private static LogsDatabase instance;
    abstract LogDao logDao();
    abstract CategoryDAO catDao();

    public static synchronized LogsDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),LogsDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new NoteAsyncTask(instance.logDao(),ADD_TEMP).execute();
        }
    };
}