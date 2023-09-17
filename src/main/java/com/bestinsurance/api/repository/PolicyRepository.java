package com.bestinsurance.api.repository;

import com.bestinsurance.api.domain.Policy;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface PolicyRepository extends CrudRepository<Policy, UUID> {
}
