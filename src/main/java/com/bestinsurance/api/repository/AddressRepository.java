package com.bestinsurance.api.repository;

import com.bestinsurance.api.domain.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface AddressRepository extends CrudRepository<Address, UUID> {
}
