package com.lablpII.lablpII.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lablpII.lablpII.projections.CustumerMinProjection;
import com.lablpII.lablpII.entities.Customer;

public interface CustumerRepository extends JpaRepository<Customer, Long>{
    @Query(nativeQuery = true, 
    value = "SELECT name, password FROM tb_customers WHERE" + 
    " name = :name AND password = :password")
    List<CustumerMinProjection> searchCustomer(String name, String password);
}
