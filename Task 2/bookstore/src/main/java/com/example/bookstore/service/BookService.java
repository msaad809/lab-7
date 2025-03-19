package com.example.bookstore.service;

import com.example.bookstore.dto.BookDTO;
import java.util.List;
/**
 * @author Abdul Moiz Meer
 */
public interface BookService {
    BookDTO addBook(BookDTO bookDTO);
    List<BookDTO> addMultipleBooks(List<BookDTO> bookDTOs);
    List<BookDTO> getBooksAbovePrice(double price);
    boolean updateBookPrice(Long id, double newPrice);
    boolean deleteBookIfOutOfStock(Long id);
    List<BookDTO> searchBooksByTitle(String title);
}
