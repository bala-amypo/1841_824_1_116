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

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Contract contract;

    private LocalDate deliveryDate;

    public DeliveryRecord() {}

    public Long getId() {
        return id;
    }

    public Contract getContract() {
        return contract;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
