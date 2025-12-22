package com.example.demo.service.serImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRule;
import com.example.demo.repository.BreachRuleRepository;
import com.example.demo.service.BreachRuleService;

@Service
public class BreachRuleServiceImpl implements BreachRuleService {

    @Autowired
    BreachRuleRepository BreachRepoObj;

    @Override
    public BreachRule createRule(BreachRule rule) {
        return BreachRepoObj.save(rule);
    }

    @Override
    public BreachRule updateRule(Long id, BreachRule rule) {
        Optional<BreachRule> existing = BreachRepoObj.findById(id);
        if (existing.isPresent()) {
            BreachRule r = existing.get();
            r.setRuleName(rule.getRuleName());
            r.setPenaltyPerDay(rule.getPenaltyPerDay());
            r.setMaxPenaltyPercentage(rule.getMaxPenaltyPercentage());
            r.setActive(rule.getActive() != null ? rule.getActive() : true);
            return BreachRepoObj.save(r);
        }
        return null;
    }

    @Override
    public BreachRule getActiveDefaultOrFirst() {
        List<BreachRule> activeRules = BreachRepoObj.findByActiveTrueOrderByIdAsc();
        return activeRules.isEmpty() ? null : activeRules.get(0);
    }

    @Override
    public List<BreachRule> getAllRules() {
        return BreachRepoObj.findAll();
    }

    @Override
    public void deactivateRule(Long id) {
        Optional<BreachRule> existing = BreachRepoObj.findById(id);
        existing.ifPresent(r -> {
            r.setActive(false);
            BreachRepoObj.save(r);
        });
    }
}
