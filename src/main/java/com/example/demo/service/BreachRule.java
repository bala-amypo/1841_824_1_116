package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BreachRule;

public interface BreachRuleService  {
    public BreachRule createRule(BreachRule rule);
    public BreachRule updateRule(Long id, BreachRule rule);
    public BreachRule getActiveDefaultOrFirst();
    public List<BreachRule> getAllRules();
    public void deactivateRule(Long id);
}
