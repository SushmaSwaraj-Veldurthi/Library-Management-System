package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ISBN Number
    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    // Book Title
    @Column(nullable = false, length = 200)
    private String title;

    // Edition
    @Column(length = 50)
    private String edition;

    // Language
    @Column(length = 50)
    private String language;

    // Rack Number
    @Column(length = 30)
    private String rackNumber;

    // Price
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    // Publication Date
    private LocalDate publicationDate;

    // Total Copies
    @Column(nullable = false)
    private Integer totalCopies;

    // Available Copies
    @Column(nullable = false)
    private Integer availableCopies;

    // Description
    @Column(length = 1000)
    private String description;

    // Book Cover Image
    private String imageUrl;

    // Active Status
    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;

    // Created & Updated
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // ===========================
    // Relationships
    // ===========================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<IssueBook> issuedBooks = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (availableCopies == null) {
            availableCopies = totalCopies;
        }
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}