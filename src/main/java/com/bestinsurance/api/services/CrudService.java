package com.bestinsurance.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CrudService<T> {

    T create(final T domainObj);
    List<T> findAll();
    Optional<T> getByID(final UUID UUID);
    T update(final UUID id, final T domainObj);
    void delete(final UUID uuid);
}
