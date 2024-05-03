package com.lablpII.lablpII.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lablpII.lablpII.entities.Customer;
import com.lablpII.lablpII.projections.CustumerMinProjection;
import com.lablpII.lablpII.repositories.CustumerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustumerRepository repository;

    public List<CustumerMinProjection> authenticate(String name, String password){
        return repository.searchCustomer(name, password);
    }
}
