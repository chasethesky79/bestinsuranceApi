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
@Table(name = "cities")
public class City {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID cityId;

    @Column(nullable = false, length = 64)
    private String name;

    @Column
    private Integer population;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;

    @OneToMany(mappedBy = "city")
    private Set<Address> cityAddresses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId.equals(city.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }
}
