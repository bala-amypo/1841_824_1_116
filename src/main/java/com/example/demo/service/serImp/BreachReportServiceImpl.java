// package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.util.List;

public class BreachReportServiceImpl {

    BreachReportRepository breachReportRepository;
    PenaltyCalculationRepository penaltyCalculationRepository;
    ContractRepository contractRepository;

    public BreachReport generateReport(Long contractId) {
        contractRepository.findById(contractId)
                .orElseThrow(() -> new RuntimeException("Contract not found"));

        PenaltyCalculation pc = penaltyCalculationRepository
                .findTopByContractIdOrderByCalculatedAtDesc(contractId)
                .orElseThrow(() -> new RuntimeException("No penalty calculation"));

        BreachReport r = new BreachReport();
        r.setContract(pc.getContract());
        r.setDaysDelayed(pc.getDaysDelayed());
        r.setPenaltyAmount(pc.getCalculatedPenalty());

        return breachReportRepository.save(r);
    }

    public List<BreachReport> getReportsForContract(Long id) {
        return breachReportRepository.findByContractId(id);
    }

    public List<BreachReport> getAllReports() {
        return breachReportRepository.findAll();
    }
}
