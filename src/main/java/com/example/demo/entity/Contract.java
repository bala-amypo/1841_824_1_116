package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "contracts",
    uniqueConstraints = @UniqueConstraint(columnNames = "contractNumber")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String contractNumber;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String counterpartyName;

    @Column(nullable = false)
    private LocalDate agreedDeliveryDate;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal baseContractValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}

enum ContractStatus {
    ACTIVE,
    COMPLETED,
    BREACHED
}
