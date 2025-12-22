package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BreachReport;

public interface BreachReportService  {
    public BreachReport generateReport(Long contractId);
    BreachReport getReportById(Long id);
    List<BreachReport>getReportsForContract(Long contractId);
    List<BreachReport> getAllReports();
}

