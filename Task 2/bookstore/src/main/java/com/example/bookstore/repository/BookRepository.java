package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * @author Abdul Moiz Meer
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    // Get books priced above a specific amount
    @Query("SELECT b FROM Book b WHERE b.price > :price")
    List<Book> findBooksAbovePrice(double price);

    // Update book price by ID
    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.price = :newPrice WHERE b.id = :id")
    int updateBookPriceById(Long id, double newPrice);

    // Delete book if out of stock
    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.id = :id AND b.inStock = false")
    int deleteBookIfOutOfStock(Long id);

    // Search books by title (case-insensitive)
    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Book> searchBooksByTitle(String title);
}
