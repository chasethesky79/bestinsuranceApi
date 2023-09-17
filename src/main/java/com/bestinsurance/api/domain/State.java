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
@Table(name = "states")
public class State {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID stateId;

    @Column(nullable = false, length = 64)
    private String name;

    @Column
    private Integer population;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "state")
    private Set<City> stateCities;

    @OneToMany(mappedBy = "state")
    private Set<Address> stateAddresses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return stateId.equals(state.stateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateId);
    }
 }
