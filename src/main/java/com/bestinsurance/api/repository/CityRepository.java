package com.bestinsurance.api.repository;

import com.bestinsurance.api.domain.City;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface CityRepository extends CrudRepository<City, UUID> {
}
