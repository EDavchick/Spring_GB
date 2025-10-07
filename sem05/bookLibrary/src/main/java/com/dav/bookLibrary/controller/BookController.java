package com.dav.bookLibrary.controller;


import com.dav.bookLibrary.model.Book;
import com.dav.bookLibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping()
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping()
    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }

}
