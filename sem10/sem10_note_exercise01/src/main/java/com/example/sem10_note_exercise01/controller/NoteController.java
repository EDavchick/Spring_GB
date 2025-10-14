package com.example.sem10_note_exercise01.controller;

import com.example.sem10_note_exercise01.model.Note;
import com.example.sem10_note_exercise01.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(ResponseEntity::ok)// // если найдено → 200 OK
                .orElse(ResponseEntity.notFound().build()); // если нет → 404 Not Found
    }

    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return noteService.saveOrUpdate(note);
    }

    @PutMapping("{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteForUpdate) {
        Note noteById = noteService.getNoteById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id " + id));

        noteById.setTitle(noteForUpdate.getTitle());
        noteById.setContent(noteForUpdate.getContent());

        return noteService.saveOrUpdate(noteById);
    }

    @DeleteMapping("{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
    }
}
