// package com.example.demo.service.impl;

package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;

import java.time.LocalDate;
import java.util.List;

public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private DeliveryRecordRepository deliveryRecordRepository;
    private ContractRepository contractRepository;

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRecord r) {
        if (r.getDeliveryDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Delivery date cannot be in the future");
        }

        Contract c = contractRepository.findById(r.getContract().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));

        r.setContract(c);
        return deliveryRecordRepository.save(r);
    }

    @Override
    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        return deliveryRecordRepository
                .findFirstByContractIdOrderByDeliveryDateDesc(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("No delivery records found"));
    }

    @Override
    public DeliveryRecord getRecordById(Long id) {
        return deliveryRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery record not found"));
    }

    @Override
    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId) {
        return deliveryRecordRepository.findByContractIdOrderByDeliveryDateAsc(contractId);
    }
}

