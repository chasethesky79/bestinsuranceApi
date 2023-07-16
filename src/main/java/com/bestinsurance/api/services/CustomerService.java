package com.bestinsurance.api.services;

import com.bestinsurance.api.domain.Customer;
import com.bestinsurance.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService implements CrudService<Customer>{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getByID(UUID uuid) {
        return customerRepository.findById(uuid);
    }

    @Override
    public Customer update(Customer domainObj) {
        return null;
    }

    @Override
    public void delete(String UUID) {

    }
}
