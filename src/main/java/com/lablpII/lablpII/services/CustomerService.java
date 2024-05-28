package com.lablpII.lablpII.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lablpII.lablpII.dto.CustomerDto;
import com.lablpII.lablpII.entities.Customer;
import com.lablpII.lablpII.repositories.CustumerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustumerRepository repository;

	@Transactional(readOnly = true)
    public CustomerDto findById(Long id) {
	    Optional<Customer> result = repository.findById(id);
		Customer entity = result.get();
		return new CustomerDto(entity);
	}

	@Transactional(readOnly = true)
    public Page<CustomerDto> findAll(Pageable pageable) {
	    Page<Customer> result = repository.findAll(pageable);
		return result.map(x -> new CustomerDto(x));
	}

	@Transactional
	public CustomerDto insert(CustomerDto dto){
		Customer entity = new Customer();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());

		entity = repository.save(entity);

		return new CustomerDto(entity);
	}

	@Transactional
	public CustomerDto update(Long id, CustomerDto dto){
		Customer entity = repository.getReferenceById(id);
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());

		entity = repository.save(entity);
		return new CustomerDto(entity);
	}

	@Transactional
	public void delete(Long id){
		repository.deleteById(id);
	}
}
