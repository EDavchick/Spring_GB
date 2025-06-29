package com.dav.example02.service;

import com.dav.example02.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

}
