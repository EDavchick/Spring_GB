package com.example.sem10_note_exercise01.service;

import com.example.sem10_note_exercise01.model.Note;
import com.example.sem10_note_exercise01.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
//        List<Note> notes = noteRepository.findAll();
//        if (notes.isEmpty()) {
//            throw new NoSuchElementException("There are no notes in database");
//        }
//        return notes;
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note saveOrUpdate(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
