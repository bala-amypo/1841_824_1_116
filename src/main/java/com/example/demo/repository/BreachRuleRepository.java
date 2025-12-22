package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BreachRule;

public interface BreachRuleRepository extends JpaRepository<BreachRule, Long> {
    List<BreachRule> findByActiveTrueOrderByIdAsc();
}
