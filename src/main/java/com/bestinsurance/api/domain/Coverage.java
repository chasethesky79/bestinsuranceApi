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
@Table(name = "coverages")
public class Coverage {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID coverageId;

    @Column(nullable = false, length = 16)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToMany(mappedBy = "coverages")
    private Set<Policy> policies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coverage coverage = (Coverage) o;
        return coverageId.equals(coverage.coverageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coverageId);
    }
}
