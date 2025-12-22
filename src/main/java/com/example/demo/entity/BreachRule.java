
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
    public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getRuleName() {
    return ruleName;
}

public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
}

public BigDecimal getPenaltyPerDay() {
    return penaltyPerDay;
}

public void setPenaltyPerDay(BigDecimal penaltyPerDay) {
    this.penaltyPerDay = penaltyPerDay;
}

public double getMaxPenaltyPercentage() {
    return maxPenaltyPercentage;
}

public void setMaxPenaltyPercentage(Double maxPenaltyPercentage) {
    this.maxPenaltyPercentage = maxPenaltyPercentage;
}

public Boolean getActive() {
    return active;
}

public void setActive(Boolean active) {
    this.active = active;
}

}

