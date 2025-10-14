package com.example.example02_seminar6.service;

import com.example.example02_seminar6.model.Book;
import com.example.example02_seminar6.model.Reader;
import com.example.example02_seminar6.repository.BookRepository;
import com.example.example02_seminar6.repository.ReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;

    public List<Reader> findAll() {
        return readerRepository.findAll();

    }

    public Optional<Reader> findById(Long id) {
        return readerRepository.findById(id);
    }

    public Reader createAndSaveReader(Reader reader) {
        return readerRepository.save(reader);
    }


}
