// package com.example.demo.entity;

// import java.time.LocalDate;
// import java.time.LocalDateTime;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Column;

// import lombok.Getter;
// import lombok.Setter;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Entity
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class DeliveryRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "contract_id", nullable = false)
//     private Contract contract;

//     @Column(nullable = false)
//     private String notes;

//     @Column(nullable = false)
//     private LocalDate deliveryDate;

//     @Column(nullable = false)
//     private LocalDateTime createdAt;
// }

@Entity
public class PenaltyCalculation {

    @ManyToOne
    private Contract contract;

    private Integer daysDelayed;
    private BigDecimal calculatedPenalty;

    public PenaltyCalculation() {} // ✅ REQUIRED

    public Contract getContract() {
        return contract;
    }

    public Integer getDaysDelayed() {
        return daysDelayed;
    }

    public BigDecimal getCalculatedPenalty() {
        return calculatedPenalty;
    }
}
