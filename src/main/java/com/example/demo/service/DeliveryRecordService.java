package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.DeliveryRecord;

public interface DeliveryRecordService  {
public DeliveryRecord createDeliveryRecord(DeliveryRecord record);
public DeliveryRecord getRecordById(Long id);
public List<DeliveryRecord> getDeliveryRecordsForContract(Long contractId);
public DeliveryRecord getLatestDeliveryRecord(Long contractId);
 
}
