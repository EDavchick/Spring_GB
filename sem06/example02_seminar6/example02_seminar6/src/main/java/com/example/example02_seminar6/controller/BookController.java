package com.example.example02_seminar6.controller;

import com.example.example02_seminar6.exception.ResourceNotFoundException;
import com.example.example02_seminar6.model.Book;
import com.example.example02_seminar6.model.Reader;
import com.example.example02_seminar6.service.BookService;
import com.example.example02_seminar6.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final ReaderService readerService;

    /**
     * GET/books получение списка всех книг
     * @return все книги
     */
    @GetMapping
    public List<Book> findAllBooks(){
        return bookService.getAllBooks();
    }

    /**
     * GET/books/{id} - получение книги по ID
     * @param id ID книги
     * @return книга
     */
    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book bookById = bookService.getBookById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Book with id " + id + " not found"));
        return ResponseEntity.ok(bookById);
    }

    /**
     * POST/books- добавление новой книги
     * @param book нужная книга, добавляем данные
     * @return новую или измененную книгу
     */
    @PostMapping
    public Book createAndSaveBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    /**
     *  DELETE/books/{id}- удаление книги
     * @param id книга
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    /**
     * PUT/books/{id}/reader/{readerId}- назначение читателя для книги
     * @param id ID книги
     * @param readerId ID читателя
     * @return назначаем читателя для книги
     */

    @PutMapping("{id}/reader/{readerId}")
    public ResponseEntity<Book> assignReaderToBook(@PathVariable Long id, @PathVariable Long readerId) {
        Optional<Book> bookOptional = bookService.getBookById(id);
        Optional<Reader> readerOptional = readerService.findById(readerId);

        if (bookOptional.isPresent() && readerOptional.isPresent()) {
            Book book = bookOptional.get();
            Reader reader = readerOptional.get();
            book.setReader(reader);
            bookService.addBook(book);
            return  ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Update ID book
     * @param book book
     * @param id ID book
     * @return new book
     */
    @PutMapping("{id}")
    public Book updateIdBook(@RequestBody Book book, @PathVariable Long id) {
        book.setId(id);
        return bookService.addBook(book);
    }
}

/*
[
    {
        "id": 1,
        "title": "War and Peace",
        "author": "Lev Tolstoy",
        "isbn": "12345nsd",
        "publicationYear": 2002
    },
    {
        "id": 2,
        "title": "Fathers and Sons",
        "author": "Ivan Turgenev",
        "isbn": "432jdgjj",
        "publicationYear": 1995
    },
    {
        "id": 3,
        "title": "Crime and Punishment",
        "author": "Fedor Dostoevskiy",
        "isbn": "048rysjf0",
        "publicationYear": 2023
    }
]
 */
