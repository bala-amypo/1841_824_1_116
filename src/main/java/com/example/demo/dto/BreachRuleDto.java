package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
public class BreachRuleDto {
    private String ruleName;
    private BigDecimal penaltyPerDay;
}
