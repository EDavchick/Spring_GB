package com.example.mynotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository repository;

    @Autowired
    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NoteEntity> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public NoteEntity getNoteById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    @Override
    public NoteEntity createNote(Note note) {
        return null;
    }

//    @Override
//    public Note createNote(Note note) {
//        return repository.save(note);
//    }

    @Override
    public NoteEntity updateNote(Long id, Note note) {
        // мы должны сначала проверить, существует ли заметка с данным ID
        NoteEntity existingNote = getNoteById(id);
        // обновляем поля существующей заметки
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        // сохраняем и возвращаем обновленную заметку
        return repository.save(existingNote);
    }

    @Override
    public void deleteNote(Long id) {
        // проверяем, существует ли заметка с данным ID
         getNoteById(id);
        // если да, то удаляем ее
         repository.deleteById(id);
    }
}
