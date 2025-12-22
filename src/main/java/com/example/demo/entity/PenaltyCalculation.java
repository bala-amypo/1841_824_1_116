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
@Table(name = "penalty_calculation")
public class PenaltyCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @ManyToOne(optional = false)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract; 

    @ManyToOne
    @JoinColumn(name = "delivery_record_id")
    private DeliveryRecord deliveryRecord; 

    @ManyToOne(optional = false)
    @JoinColumn(name = "breach_rule_id", nullable = false)
    private BreachRule breachRule; 

    @Column(nullable = false)
    private Integer daysDelayed; 

    @Column(nullable = false)
    private BigDecimal calculatedPenalty; 

    @Column(nullable = false, updatable = false)
    private LocalDateTime calculatedAt; 

    public PenaltyCalculation(Contract contract, DeliveryRecord deliveryRecord, BreachRule breachRule,
                              Integer daysDelayed, BigDecimal calculatedPenalty) {
        this.contract = contract;
        this.deliveryRecord = deliveryRecord;
        this.breachRule = breachRule;
        this.daysDelayed = daysDelayed;
        this.calculatedPenalty = calculatedPenalty;
        this.calculatedAt = LocalDateTime.now();
    }

}

