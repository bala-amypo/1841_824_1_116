// package com.example.demo.service.impl;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;

import java.util.List;

public class BreachRuleServiceImpl {

    BreachRuleRepository breachRuleRepository;

    public BreachRule createRule(BreachRule r) {
        if (r.getPenaltyPerDay().signum() <= 0) {
            throw new IllegalArgumentException("Penalty must be > 0");
        }
        if (r.getMaxPenaltyPercentage() > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        return breachRuleRepository.save(r);
    }

    public void deactivateRule(Long id) {
        BreachRule r = breachRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        r.setActive(false);
        breachRuleRepository.save(r);
    }

    public BreachRule getActiveDefaultOrFirst() {
        return breachRuleRepository
                .findFirstByActiveTrueOrderByIsDefaultRuleDesc()
                .orElseThrow(() -> new RuntimeException("No active breach rule"));
    }

    public List<BreachRule> getAllRules() {
        return breachRuleRepository.findAll();
    }
}
