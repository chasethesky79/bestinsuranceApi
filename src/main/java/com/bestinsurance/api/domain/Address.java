package com.bestinsurance.api.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID addressId;

    @Column(nullable = false, length = 128)
    private String address;

    @Column(length = 16)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, insertable = true)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, insertable = true)
    private City city;

    @ManyToOne
    @JoinColumn(name = "state_id", insertable = true)
    private State state;
}
