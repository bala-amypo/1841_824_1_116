package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PenaltyCalculation;
import com.example.demo.entity.Contract;

@Repository
public interface PenaltyCalculationRepository extends JpaRepository<PenaltyCalculation, Long> {

    List<PenaltyCalculation> findByContractOrderByCalculatedAtDesc(Contract contract);
}
