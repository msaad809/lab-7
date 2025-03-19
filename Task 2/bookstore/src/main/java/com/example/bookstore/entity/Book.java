package com.example.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;
/**
 * @author Abdul Moiz Meer
 */
@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private boolean inStock;
}
