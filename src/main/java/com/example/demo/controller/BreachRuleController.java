package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/breach-rules")
public class BreachRuleController {

    @Autowired
    private BreachRuleService breachRuleServiceObj;

    @PostMapping("/")
    public BreachRule createRule(@RequestBody BreachRule rule) {
        return breachRuleServiceObj.createRule(rule);
    }

    @PutMapping("/{id}")
    public BreachRule updateRule(@PathVariable Long id, @RequestBody BreachRule rule) {
        return breachRuleServiceObj.updateRule(id, rule);
    }

    public BreachRule getRuleById(@PathVariable Long id) {
        return breachRuleServiceObj.getAllRules()
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/")
    public List<BreachRule> getAllRules() {
        return breachRuleServiceObj.getAllRules();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateRule(@PathVariable Long id) {
        breachRuleServiceObj.deactivateRule(id);
    }
}
