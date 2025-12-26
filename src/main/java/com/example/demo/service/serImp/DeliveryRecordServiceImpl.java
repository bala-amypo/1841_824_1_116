// package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;

import java.time.LocalDate;
import java.util.List;

public class DeliveryRecordServiceImpl {

    DeliveryRecordRepository deliveryRecordRepository;
    ContractRepository contractRepository;

    public DeliveryRecord createDeliveryRecord(DeliveryRecord r) {
        if (r.getDeliveryDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Delivery date cannot be in the future");
        }
        contractRepository.findById(r.getContract().getId())
                .orElseThrow(() -> new RuntimeException("Contract not found"));
        return deliveryRecordRepository.save(r);
    }

    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        return deliveryRecordRepository
                .findFirstByContractIdOrderByDeliveryDateDesc(contractId)
                .orElseThrow(() -> new RuntimeException("No delivery records found"));
    }

    public DeliveryRecord getRecordById(Long id) {
        return deliveryRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery record not found"));
    }

    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId) {
        return deliveryRecordRepository.findByContractIdOrderByDeliveryDateAsc(contractId);
    }
}
