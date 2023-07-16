package com.bestinsurance.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CrudService<T> {

    T create(T domainObj);
    List<T> findAll();
    Optional<T> getByID(UUID UUID);
    T update(T domainObj);
    void delete(String UUID);
}
