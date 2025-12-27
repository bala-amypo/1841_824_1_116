// package com.example.demo.entity;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @NoArgsConstructor
// public class BreachReport {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id; 

//     @ManyToOne(optional = false)
//     @JoinColumn(name = "contract_id", nullable = false)
//     private Contract contract; 

//     @Column(nullable = false)
//     private Integer daysDelayed; 

//     @Column(nullable = false)
//     private BigDecimal penaltyAmount; 
//     @Column(nullable = false)
//     private String reportStatus = "GENERATED"; 

//     @Column(nullable = false, updatable = false)
//     private LocalDateTime generatedAt; 

//     public BreachReport(Contract contract, Integer daysDelayed, BigDecimal penaltyAmount) {
//         this.contract = contract;
//         this.daysDelayed = daysDelayed;
//         this.penaltyAmount = penaltyAmount;
//         this.reportStatus = "GENERATED";
//         this.generatedAt = LocalDateTime.now();
//     }
// public Long getId() {
//     return id;
// }

// public void setId(Long id) {
//     this.id = id;
// }

// public Contract getContract() {
//     return contract;
// }

// public void setContract(Contract contract) {
//     this.contract = contract;
// }

// public Integer getDaysDelayed() {
//     return daysDelayed;
// }

// public void setDaysDelayed(Integer daysDelayed) {
//     this.daysDelayed = daysDelayed;
// }

// public BigDecimal getPenaltyAmount() {
//     return penaltyAmount;
// }

// public void setPenaltyAmount(BigDecimal penaltyAmount) {
//     this.penaltyAmount = penaltyAmount;
// }

// public String getReportStatus() {
//     return reportStatus;
// }

// public void setReportStatus(String reportStatus) {
//     this.reportStatus = reportStatus;
// }

// public LocalDateTime getGeneratedAt() {
//     return generatedAt;
// }

// public void setGeneratedAt(LocalDateTime generatedAt) {
//     this.generatedAt = generatedAt;
// }

// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class BreachReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Contract contract;

    private Integer daysDelayed;

    private BigDecimal penaltyAmount;

    public BreachReport() {}

    public BreachReport(Contract contract, Integer daysDelayed, BigDecimal penaltyAmount) {
        this.contract = contract;
        this.daysDelayed = daysDelayed;
        this.penaltyAmount = penaltyAmount;
    }

    public Long getId() {
        return id;
    }

    public Contract getContract() {
        return contract;
    }

    public Integer getDaysDelayed() {
        return daysDelayed;
    }

    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setDaysDelayed(Integer daysDelayed) {
        this.daysDelayed = daysDelayed;
    }

    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }
}

