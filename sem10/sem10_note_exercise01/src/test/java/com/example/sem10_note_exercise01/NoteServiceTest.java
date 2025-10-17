package com.example.sem10_note_exercise01;

import com.example.sem10_note_exercise01.model.Note;
import com.example.sem10_note_exercise01.repository.NoteRepository;
import com.example.sem10_note_exercise01.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @InjectMocks
    private NoteService noteService;

    @Mock
    private NoteRepository noteRepository;

    @Test
    public void getAllNotes() {
        Note note = new Note();
        note.setTitle("Test title");
        note.setContent("Test Content");

        List<Note> expectedNotes = Collections.singletonList(note);

        when(noteRepository.findAll()).thenReturn(expectedNotes);

        List<Note> actualNotes = noteService.getAllNotes();

        assertEquals(expectedNotes, actualNotes);
    }

}
