package com.example.demo.entity;

import com.example.demo.entity.enum_files.ContractStatus;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor
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

    public Contract(LocalDate agreedDeliveryDate, BigDecimal baseContractValue, String contractNumber, String counterpartyName, LocalDateTime createdAt, ContractStatus status, String title, LocalDateTime updatedAt) {
        this.agreedDeliveryDate = agreedDeliveryDate;
        this.baseContractValue = baseContractValue;
        this.contractNumber = contractNumber;
        this.counterpartyName = counterpartyName;
        this.createdAt = createdAt;
        this.status = status;
        this.title = title;
        this.updatedAt = updatedAt;
    }

    
}

