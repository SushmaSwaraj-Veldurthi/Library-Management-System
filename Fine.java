package com.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Issue record associated with this fine
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_book_id", nullable = false, unique = true)
    private IssueBook issueBook;

    // Student who has to pay the fine
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Fine amount
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    // Reason for fine
    @Column(length = 255)
    private String reason;

    // Fine status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private FineStatus status = FineStatus.UNPAID;

    // Payment date
    private LocalDate paymentDate;

    // Payment method
    @Column(length = 50)
    private String paymentMethod;

    // Transaction reference (optional)
    @Column(length = 100)
    private String transactionId;

    // Additional remarks
    @Column(length = 500)
    private String remarks;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (amount == null) {
            amount = BigDecimal.ZERO;
        }
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}