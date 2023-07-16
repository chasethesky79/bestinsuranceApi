package com.bestinsurance.api.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Customer {

    private UUID customerId;
    private String name;
    private String surName;
}
