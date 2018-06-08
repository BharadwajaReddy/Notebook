package com.notebook.bharadwaja.om;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.notebook.bharadwaja.om.adapter.NotesAdapter;
import com.notebook.bharadwaja.om.notedb.NoteDatabase;
import com.notebook.bharadwaja.om.notedb.model.Note;

import java.util.List;

/**
 * Created by Bharadwaja on 08-06-2018.
 */

public class DummyClass {

    private TextView textViewMsg;
    private RecyclerView recyclerView;
    private NoteDatabase noteDatabase;
    private List<Note> notes;
    private NotesAdapter notesAdapter;
    private int pos;
}
