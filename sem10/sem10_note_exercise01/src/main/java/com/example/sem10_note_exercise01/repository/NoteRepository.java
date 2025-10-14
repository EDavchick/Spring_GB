package com.example.sem10_note_exercise01.repository;

import com.example.sem10_note_exercise01.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
