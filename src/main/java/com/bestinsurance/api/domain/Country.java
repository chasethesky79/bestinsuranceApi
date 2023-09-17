package com.bestinsurance.api.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID countryId;

    @Column(nullable = false, length = 64)
    private String name;

    @Column
    private Integer population;

    @OneToMany(mappedBy = "country")
    private Set<State> countryStates;

    @OneToMany(mappedBy = "country")
    private Set<City> countryCities;

    @OneToMany(mappedBy = "country")
    private Set<Address> countryAddresses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryId.equals(country.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId);
    }
}
