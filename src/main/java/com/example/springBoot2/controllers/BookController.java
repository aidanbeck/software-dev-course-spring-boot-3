package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import com.example.springBoot2.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllItems() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getItem( @PathVariable int id ) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Book addItem( @RequestBody Book book ) {
        return bookRepository.save(book); // does this return Book?
    }

    @PutMapping("/{id}")
    public Book updateItem( @PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public Book deleteItem( @PathVariable int id ) {
        Book reportBook = bookRepository.findById(id).orElse(null);
        bookRepository.deleteById(id);
        return reportBook;
    }

}
