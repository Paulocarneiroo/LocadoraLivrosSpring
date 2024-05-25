package com.lablpII.lablpII.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.lablpII.lablpII.entities.Customer;

public interface CustumerRepository extends JpaRepository<Customer, Long>{
    
}
