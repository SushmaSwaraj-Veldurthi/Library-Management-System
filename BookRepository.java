package com.library.repository;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.Category;
import com.library.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // ===========================
    // Find by ISBN
    // ===========================
    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    // ===========================
    // Find by Title
    // ===========================
    List<Book> findByTitleContainingIgnoreCase(String title);

    // ===========================
    // Author
    // ===========================
    List<Book> findByAuthor(Author author);

    // ===========================
    // Category
    // ===========================
    List<Book> findByCategory(Category category);

    // ===========================
    // Publisher
    // ===========================
    List<Book> findByPublisher(Publisher publisher);

    // ===========================
    // Language
    // ===========================
    List<Book> findByLanguageContainingIgnoreCase(String language);

    // ===========================
    // Edition
    // ===========================
    List<Book> findByEditionContainingIgnoreCase(String edition);

    // ===========================
    // Rack Number
    // ===========================
    List<Book> findByRackNumber(String rackNumber);

    // ===========================
    // Active Books
    // ===========================
    List<Book> findByActiveTrue();

    List<Book> findByActiveFalse();

    // ===========================
    // Available Books
    // ===========================
    List<Book> findByAvailableCopiesGreaterThan(Integer copies);

    // ===========================
    // Out of Stock
    // ===========================
    List<Book> findByAvailableCopies(Integer copies);

    // ===========================
    // Publication Date
    // ===========================
    List<Book> findByPublicationDateBetween(
            java.time.LocalDate startDate,
            java.time.LocalDate endDate
    );

    // ===========================
    // Price
    // ===========================
    List<Book> findByPriceBetween(
            BigDecimal minPrice,
            BigDecimal maxPrice
    );

    // ===========================
    // Combined Search
    // ===========================
    List<Book> findByTitleContainingIgnoreCaseOrIsbnContainingIgnoreCase(
            String title,
            String isbn
    );

    List<Book> findByTitleContainingIgnoreCaseAndActive(
            String title,
            Boolean active
    );

    List<Book> findByCategoryAndActiveTrue(Category category);

    List<Book> findByAuthorAndActiveTrue(Author author);

    List<Book> findByPublisherAndActiveTrue(Publisher publisher);

}