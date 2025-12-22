package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BreachRule;
import com.example.demo.service.BreachRuleService;

@RestController
@RequestMapping("/api/breach-rules")
public class BreachRuleController {

    @Autowired
    private BreachRuleService breachRuleService;

    @PostMapping("/")
    public BreachRule createRule(@RequestBody BreachRule rule) {
        return breachRuleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public BreachRule updateRule(@PathVariable Long id, @RequestBody BreachRule rule) {
        return breachRuleService.updateRule(id, rule);
    }

    public BreachRule getRuleById(@PathVariable Long id) {
        return breachRuleService.getAllRules()
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/")
    public List<BreachRule> getAllRules() {
        return breachRuleService.getAllRules();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateRule(@PathVariable Long id) {
        breachRuleService.deactivateRule(id);
    }
}
