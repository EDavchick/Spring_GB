package com.example.example02_seminar6.controller;

import com.example.example02_seminar6.exception.ResourceNotFoundException;
import com.example.example02_seminar6.model.Reader;
import com.example.example02_seminar6.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderService readerService;

    /**
     * GET/readers- получение списка всех читателей
     * @return список всех читателей
     */
    @GetMapping()
    public List<Reader> findAllReaders(){
        return readerService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Reader> findReaderById(Long id) {
        System.out.println("Method findReaderById has launched");
        Reader readerById = readerService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Reader with id " + id + " not found"));
        System.out.println("Loaded reader: " + readerById);
        return ResponseEntity.ok(readerById);
    }

    /**
     * POST/readers- добавление нового читателя
     * @param reader читатель
     * @return новый читатель
     */
    @PostMapping()
    public Reader addReader(@RequestBody Reader reader) {
        return readerService.createAndSaveReader(reader);
    }
}
