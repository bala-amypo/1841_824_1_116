package com.example.demo.service.serImp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contract;
import com.example.demo.entity.enum_files.ContractStatus;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract createContract(Contract contract) {
        contract.setContractNumber("CNT-" + System.currentTimeMillis()); // ✅ IMPORTANT
        contract.setStatus(ContractStatus.ACTIVE);
        contract.setCreatedAt(LocalDateTime.now());
        contract.setUpdatedAt(LocalDateTime.now());
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract existing = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found"));

        existing.setTitle(contract.getTitle());
        existing.setCounterpartyName(contract.getCounterpartyName());
        existing.setAgreedDeliveryDate(contract.getAgreedDeliveryDate());
        existing.setBaseContractValue(contract.getBaseContractValue());
        existing.setUpdatedAt(LocalDateTime.now());

        return contractRepository.save(existing);
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found"));
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public void updateContractStatus(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found"));

        contract.setStatus(ContractStatus.COMPLETED);
        contract.setUpdatedAt(LocalDateTime.now());
        contractRepository.save(contract);
    }
}
