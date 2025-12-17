package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String contractNumber;

    private String title;
    private String counterpartName;

    @Temporal(TemporalType.DATE)
    private Date agreedDeliveryDate;

    private BigDecimal baseContractValue;
    private String status;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Contract() {
    }

    public Contract(String contractNumber,
                    String title,
                    String counterpartName,
                    Date agreedDeliveryDate,
                    BigDecimal baseContractValue,
                    String status) {

        this.contractNumber = contractNumber;
        this.title = title;
        this.counterpartName = counterpartName;
        this.agreedDeliveryDate = agreedDeliveryDate;
        this.baseContractValue = baseContractValue;
        this.status = status;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCounterpartName() {
        return counterpartName;
    }

    public void setCounterpartName(String counterpartName) {
        this.counterpartName = counterpartName;
    }
}
