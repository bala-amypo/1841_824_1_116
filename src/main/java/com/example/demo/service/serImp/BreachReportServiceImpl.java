package com.example.demo.service.serImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachReport;
import com.example.demo.entity.Contract;
import com.example.demo.repository.BreachReportRepository;
import com.example.demo.repository.PenaltyCalculationRepository;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.BreachReportService;

@Service
public class BreachReportServiceImpl implements BreachReportService {

    private final BreachReportRepository breachReportRepoObj;
    private final PenaltyCalculationRepository penaltyCalculationRepoObj;
    private final ContractRepository contractRepoObj;

    
    public BreachReportServiceImpl(BreachReportRepository breachReportRepoObj,
                                   PenaltyCalculationRepository penaltyCalculationRepoObj,
                                   ContractRepository contractRepoObj) {
        this.breachReportRepoObj = breachReportRepoObj;
        this.penaltyCalculationRepoObj = penaltyCalculationRepoObj;
        this.contractRepoObj = contractRepoObj;
    }

    @Override
    public BreachReport generateReport(Long contractId) {
        Optional<Contract> contractOpt = contractRepoObj.findById(contractId);
        if (contractOpt.isEmpty()) {
            return null; 
        }
        Contract contract = contractOpt.get();

        int daysDelayed = 0;
        java.math.BigDecimal penaltyAmount = java.math.BigDecimal.ZERO;

        
        BreachReport report = new BreachReport(contract, daysDelayed, penaltyAmount);
        return breachReportRepoObj.save(report);
    }

    @Override
    public BreachReport getReportById(Long id) {
        return breachReportRepoObj.findById(id).orElse(null);
    }

    @Override
    public List<BreachReport> getReportsForContract(Long contractId) {
        return breachReportRepoObj.findAll()
                .stream()
                .filter(r -> r.getContract().getId().equals(contractId))
                .toList();
    }

    @Override
    public List<BreachReport> getAllReports() {
        return breachReportRepoObj.findAll();
    }
}
