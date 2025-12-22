package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BreachReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne(optional = false)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract; 

    @Column(nullable = false)
    private Integer daysDelayed; 

    @Column(nullable = false)
    private BigDecimal penaltyAmount; 
    @Column(nullable = false)
    private String reportStatus = "GENERATED"; 

    @Column(nullable = false, updatable = false)
    private LocalDateTime generatedAt; 

    public BreachReport(Contract contract, Integer daysDelayed, BigDecimal penaltyAmount) {
        this.contract = contract;
        this.daysDelayed = daysDelayed;
        this.penaltyAmount = penaltyAmount;
        this.reportStatus = "GENERATED";
        this.generatedAt = LocalDateTime.now();
    }

}
