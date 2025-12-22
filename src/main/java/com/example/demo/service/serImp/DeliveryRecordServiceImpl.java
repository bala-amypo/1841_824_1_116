package com.example.demo.service.serImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
@Service
public class DeliveryRecordServiceImpl implements  DeliveryRecordService {
     @Autowired
     DeliveryRecordRepository repositoryObj;

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRecord record) {
        return repositoryObj.save(record);
    }

    @Override
    public DeliveryRecord getRecordById(Long id) {
        return repositoryObj.findById(id).orElse(null);
    }

    @Override
    public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId) {
        return repositoryObj.findByContractIdOrderByDeliveryDateDesc(contractId);
    }

    @Override
    public DeliveryRecord getLatestDeliveryRecord(Long contractId) {
        List<DeliveryRecord> records = repositoryObj.findByContractIdOrderByDeliveryDateDesc(contractId);
        return records.isEmpty() ? null : records.get(0);
    }
}

