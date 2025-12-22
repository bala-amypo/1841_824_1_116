
package com.example.demo.entity;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class BreachRule {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @Column(nullable = false, unique = true)
    private String ruleName; 

    @Column(nullable = false)
    private BigDecimal penaltyPerDay; 

    @Column(nullable = false)
    private Double maxPenaltyPercentage;

    @Column(nullable = false)
    private Boolean active = true; 
    
     public BreachRule(String ruleName, BigDecimal penaltyPerDay, Double maxPenaltyPercentage, Boolean active, Boolean isDefaultRule) {
        this.ruleName = ruleName;
        this.penaltyPerDay = penaltyPerDay;
        this.maxPenaltyPercentage = maxPenaltyPercentage;
        this.active = active;

    }
}

