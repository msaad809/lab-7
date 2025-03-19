package com.example.bookstore.service;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Abdul Moiz Meer
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setInStock(bookDTO.isInStock());

        Book savedBook = bookRepository.save(book);
        return new BookDTO(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getPrice(), savedBook.isInStock());
    }

    @Override
    public List<BookDTO> addMultipleBooks(List<BookDTO> bookDTOs) {
        List<Book> books = bookDTOs.stream().map(dto -> {
            Book book = new Book();
            book.setTitle(dto.getTitle());
            book.setAuthor(dto.getAuthor());
            book.setPrice(dto.getPrice());
            book.setInStock(dto.isInStock());
            return book;
        }).collect(Collectors.toList());

        List<Book> savedBooks = bookRepository.saveAll(books);
        return savedBooks.stream().map(book ->
                        new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.isInStock()))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBooksAbovePrice(double price) {
        return bookRepository.findBooksAbovePrice(price).stream()
                .map(book -> new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.isInStock()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean updateBookPrice(Long id, double newPrice) {
        return bookRepository.updateBookPriceById(id, newPrice) > 0;
    }

    @Override
    @Transactional
    public boolean deleteBookIfOutOfStock(Long id) {
        return bookRepository.deleteBookIfOutOfStock(id) > 0;
    }

    @Override
    public List<BookDTO> searchBooksByTitle(String title) {
        return bookRepository.searchBooksByTitle(title).stream()
                .map(book -> new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.isInStock()))
                .collect(Collectors.toList());
    }
}
