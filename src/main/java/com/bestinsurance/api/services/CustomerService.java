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
    public Customer create(final Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getByID(final UUID uuid) {
        return customerRepository.findById(uuid);
    }

    @Override
    public Customer update(final UUID id, final Customer customer) {
        final Customer existingCustomer = customerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format(
                        "Customer not found for id %s", id)));
        customer.setCustomerId(existingCustomer.getCustomerId());
        customer.setName(existingCustomer.getName());
        customer.setSurName(existingCustomer.getSurName());
        return customerRepository.save(customer);
    }

    @Override
    public void delete(final UUID UUID) {

    }
}
