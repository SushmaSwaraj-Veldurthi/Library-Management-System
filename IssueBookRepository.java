package com.library.repository;

import com.library.entity.Book;
import com.library.entity.IssueBook;
import com.library.entity.IssueStatus;
import com.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBook, Long> {

    // ===========================
    // User Queries
    // ===========================

    List<IssueBook> findByUser(User user);

    List<IssueBook> findByUserId(Long userId);

    // ===========================
    // Book Queries
    // ===========================

    List<IssueBook> findByBook(Book book);

    List<IssueBook> findByBookId(Long bookId);

    // ===========================
    // Status Queries
    // ===========================

    List<IssueBook> findByStatus(IssueStatus status);

    List<IssueBook> findByStatusOrderByIssueDateDesc(IssueStatus status);

    // ===========================
    // Due Date Queries
    // ===========================

    List<IssueBook> findByDueDateBefore(LocalDate date);

    List<IssueBook> findByDueDate(LocalDate dueDate);

    List<IssueBook> findByDueDateBetween(LocalDate startDate,
                                         LocalDate endDate);

    // ===========================
    // Return Date Queries
    // ===========================

    List<IssueBook> findByReturnDate(LocalDate returnDate);

    // ===========================
    // Issue Date Queries
    // ===========================

    List<IssueBook> findByIssueDateBetween(LocalDate startDate,
                                           LocalDate endDate);

    // ===========================
    // Issued By (Librarian)
    // ===========================

    List<IssueBook> findByIssuedBy(User librarian);

    List<IssueBook> findByIssuedById(Long librarianId);

    // ===========================
    // Active Borrowed Books
    // ===========================

    List<IssueBook> findByUserAndStatus(User user,
                                        IssueStatus status);

    List<IssueBook> findByBookAndStatus(Book book,
                                        IssueStatus status);

    // ===========================
    // Overdue Books
    // ===========================

    List<IssueBook> findByDueDateBeforeAndStatus(
            LocalDate date,
            IssueStatus status
    );

    // ===========================
    // Search by Remarks
    // ===========================

    List<IssueBook> findByRemarksContainingIgnoreCase(String remarks);

    // ===========================
    // Latest Records
    // ===========================

    List<IssueBook> findAllByOrderByIssueDateDesc();

}