package com.notebook.bharadwaja.om.notedb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.notebook.bharadwaja.om.notedb.dao.NoteDao;
import com.notebook.bharadwaja.om.notedb.model.Note;
import com.notebook.bharadwaja.om.util.Constants;
import com.notebook.bharadwaja.om.util.DateRoomConverter;


/**
 * Created by Pavneet_Singh on 12/31/17.
 */

@Database(entities = {Note.class}, version = 1)
@TypeConverters({DateRoomConverter.class})
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao getNoteDao();

    private static NoteDatabase notebookDB;

    // synchronized is use to avoid concurrent access in multithred environment
    public static /*synchronized*/ NoteDatabase getInstance(Context context) {
        if (null == notebookDB) {
            notebookDB = buildDatabaseInstance(context);
        }
        return notebookDB;
    }

    private static NoteDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                NoteDatabase.class,
                Constants.DB_NAME).allowMainThreadQueries().build();
    }

    public void cleanUp() {
        notebookDB = null;
    }
}