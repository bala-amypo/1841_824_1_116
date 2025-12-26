// package com.example.demo.service.serImp;

// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.Contract;
// import com.example.demo.entity.enum_files.ContractStatus;
// import com.example.demo.repository.ContractRepository;
// import com.example.demo.service.ContractService;

// @Service
// public class ContractServiceImpl implements ContractService {

//     @Autowired
//     ContractRepository contractRepositoryObj;

//     @Override
//     public Contract createContract(Contract contract) {
//         contract.setContractNumber("CNT-" + contract.getContractNumber()); 
//         contract.setStatus(ContractStatus.ACTIVE);
//         contract.setCreatedAt(LocalDateTime.now());
//         contract.setUpdatedAt(LocalDateTime.now());
//         return contractRepositoryObj.save(contract);
//     }

//     @Override
//     public Contract updateContract(Long id, Contract contract) {
//         Contract existing = contractRepositoryObj.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Contract not found"));

//         existing.setTitle(contract.getTitle());
//         existing.setCounterpartyName(contract.getCounterpartyName());
//         existing.setAgreedDeliveryDate(contract.getAgreedDeliveryDate());
//         existing.setBaseContractValue(contract.getBaseContractValue());
//         existing.setUpdatedAt(LocalDateTime.now());

//         return contractRepositoryObj.save(existing);
//     }

//     @Override
//     public Contract getContractById(Long id) {
//         return contractRepositoryObj.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Contract not found"));
//     }

//     @Override
//     public List<Contract> getAllContracts() {
//         return contractRepositoryObj.findAll();
//     }

//     @Override
//     public void updateContractStatus(Long id) {
//         Contract contract = contractRepositoryObj.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Contract not found"));

//         contract.setStatus(ContractStatus.COMPLETED);
//         contract.setUpdatedAt(LocalDateTime.now());
//         contractRepositoryObj.save(contract);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;

import java.util.List;

public class ContractServiceImpl {

    ContractRepository contractRepository;
    DeliveryRecordRepository deliveryRecordRepository;

    public Contract createContract(Contract c) {
        if (c.getBaseContractValue().signum() <= 0) {
            throw new IllegalArgumentException("Base contract value must be > 0");
        }
        return contractRepository.save(c);
    }

    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found"));
    }

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Contract updateContract(Long id, Contract u) {
        Contract c = getContractById(id);
        c.setTitle(u.getTitle());
        c.setCounterpartyName(u.getCounterpartyName());
        c.setAgreedDeliveryDate(u.getAgreedDeliveryDate());
        c.setBaseContractValue(u.getBaseContractValue());
        return contractRepository.save(c);
    }

    public void updateContractStatus(Long id) {
        Contract c = getContractById(id);
        deliveryRecordRepository
                .findFirstByContractIdOrderByDeliveryDateDesc(id)
                .ifPresent(dr -> {
                    if (dr.getDeliveryDate().isAfter(c.getAgreedDeliveryDate())) {
                        c.setStatus("BREACHED");
                    }
                });
        contractRepository.save(c);
    }
}
