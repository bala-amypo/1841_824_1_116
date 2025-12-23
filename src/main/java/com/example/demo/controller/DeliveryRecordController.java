package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/delivery-records")
public class DeliveryRecordController {

    @Autowired
    private DeliveryRecordService deliveryRecordService;

    @PostMapping("/")
    public DeliveryRecord createDeliveryRecord(@RequestBody DeliveryRecord record) {
        return deliveryRecordService.createDeliveryRecord(record);
    }

    @GetMapping("/{id}")
    public DeliveryRecord getDeliveryRecordById(@PathVariable Long id) {
        return deliveryRecordService.getRecordById(id);
    }

    @GetMapping("/contract/{contractId}")
    public List<DeliveryRecord> getDeliveryRecordsForContract(@PathVariable Long contractId) {
        return deliveryRecordService.getDeliveryRecordsForContract(contractId);
    }

    @GetMapping("/contract/{contractId}/latest")
    public DeliveryRecord getLatestDeliveryRecord(@PathVariable Long contractId) {
        return deliveryRecordService.getLatestDeliveryRecord(contractId);
    }
}
