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
import com.example.demo.entity.DeliveryRecord;
import com.example.demo.entity.enum_files.ContractStatus;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.ContractService;

import java.time.LocalDate;
import java.util.List;

public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;
    private DeliveryRecordRepository deliveryRecordRepository;

    @Override
    public Contract createContract(Contract contract) {
        if (contract.getBaseContractValue().signum() <= 0) {
            throw new IllegalArgumentException("Base contract value must be positive");
        }
        contract.setStatus(ContractStatus.ACTIVE);
        return contractRepository.save(contract);
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract updateContract(Long id, Contract updated) {
        Contract c = getContractById(id);
        c.setTitle(updated.getTitle());
        c.setCounterpartyName(updated.getCounterpartyName());
        c.setAgreedDeliveryDate(updated.getAgreedDeliveryDate());
        c.setBaseContractValue(updated.getBaseContractValue());
        return contractRepository.save(c);
    }

    @Override
    public void updateContractStatus(Long id) {
        Contract c = getContractById(id);

        deliveryRecordRepository
                .findFirstByContractIdOrderByDeliveryDateDesc(id)
                .ifPresentOrElse(
                        r -> {
                            if (r.getDeliveryDate().isAfter(c.getAgreedDeliveryDate())) {
                                c.setStatus(ContractStatus.BREACHED);
                            } else {
                                c.setStatus(ContractStatus.ACTIVE);
                            }
                        },
                        () -> c.setStatus(ContractStatus.ACTIVE)
                );

        contractRepository.save(c);
    }
}
