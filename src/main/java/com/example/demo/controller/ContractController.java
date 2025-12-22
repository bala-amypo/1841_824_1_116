package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Contract;
import com.example.demo.service.ContractService;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    ContractService contractServiceObj;

    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractServiceObj.createContract(contract);
    }
    @PutMapping("/{id}")
    public Contract updateContract(
            @PathVariable Long id,
            @RequestBody Contract contract) {
        return contractServiceObj.updateContract(id, contract);
    }


    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable Long id) {
        return contractServiceObj.getContractById(id);
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractServiceObj.getAllContracts();
    }

    
    @PutMapping("/{id}/status")
    public void updateContractStatus(@PathVariable Long id) {
        contractServiceObj.updateContractStatus(id);
    }
}
