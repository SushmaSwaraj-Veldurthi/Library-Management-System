package com.library.repository;

import com.library.entity.Fine;
import com.library.entity.FineStatus;
import com.library.entity.IssueBook;
import com.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {

    // ===========================
    // Find by Issue Book
    // ===========================

    Optional<Fine> findByIssueBook(IssueBook issueBook);

    Optional<Fine> findByIssueBookId(Long issueBookId);

    // ===========================
    // Find by User
    // ===========================

    List<Fine> findByUser(User user);

    List<Fine> findByUserId(Long userId);

    // ===========================
    // Find by Status
    // ===========================

    List<Fine> findByStatus(FineStatus status);

    List<Fine> findByStatusOrderByCreatedAtDesc(FineStatus status);

    // ===========================
    // Payment Date
    // ===========================

    List<Fine> findByPaymentDate(LocalDate paymentDate);

    List<Fine> findByPaymentDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );

    // ===========================
    // Amount
    // ===========================

    List<Fine> findByAmountGreaterThan(BigDecimal amount);

    List<Fine> findByAmountLessThan(BigDecimal amount);

    List<Fine> findByAmountBetween(
            BigDecimal minAmount,
            BigDecimal maxAmount
    );

    // ===========================
    // Payment Method
    // ===========================

    List<Fine> findByPaymentMethod(String paymentMethod);

    List<Fine> findByPaymentMethodContainingIgnoreCase(
            String paymentMethod
    );

    // ===========================
    // Transaction ID
    // ===========================

    Optional<Fine> findByTransactionId(String transactionId);

    // ===========================
    // Reason
    // ===========================

    List<Fine> findByReasonContainingIgnoreCase(String reason);

    // ===========================
    // Remarks
    // ===========================

    List<Fine> findByRemarksContainingIgnoreCase(String remarks);

    // ===========================
    // Combined Queries
    // ===========================

    List<Fine> findByUserAndStatus(
            User user,
            FineStatus status
    );

    List<Fine> findByUserAndAmountGreaterThan(
            User user,
            BigDecimal amount
    );

    List<Fine> findByStatusAndAmountGreaterThan(
            FineStatus status,
            BigDecimal amount
    );

    // ===========================
    // Latest Fines
    // ===========================

    List<Fine> findAllByOrderByCreatedAtDesc();

}