package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Abdul Moiz Meer
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @PostMapping("/add-multiple")
    public List<BookDTO> addMultipleBooks(@RequestBody List<BookDTO> bookDTOs) {
        return bookService.addMultipleBooks(bookDTOs);
    }

    @GetMapping("/above-price/{price}")
    public List<BookDTO> getBooksAbovePrice(@PathVariable double price) {
        return bookService.getBooksAbovePrice(price);
    }

    @PutMapping("/update-price/{id}")
    public boolean updateBookPrice(@PathVariable Long id, @RequestParam double price) {
        return bookService.updateBookPrice(id, price);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBookIfOutOfStock(@PathVariable Long id) {
        return bookService.deleteBookIfOutOfStock(id);
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }
}
