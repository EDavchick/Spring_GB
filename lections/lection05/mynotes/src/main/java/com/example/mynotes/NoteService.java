package com.example.mynotes;

import java.util.List;

public interface NoteService {
    List<NoteEntity> getAllNotes();

    NoteEntity getNoteById(Long id);

    NoteEntity createNote(Note note);

    NoteEntity updateNote(Long id, Note note);

    void deleteNote(Long id);
}
