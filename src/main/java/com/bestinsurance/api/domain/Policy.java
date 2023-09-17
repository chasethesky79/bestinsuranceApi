package com.bestinsurance.api.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Builder
@Data
@Entity
@Table(name = "policies")
@EntityListeners(AuditingEntityListener.class)
public class Policy {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID policyId;

    @Column(nullable = false, length = 16, unique = true)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime created;

    @LastModifiedDate
    @Column
    private OffsetDateTime updated;

    @OneToMany(mappedBy = "policy")
    private Set<Subscription> policySubscriptions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "policies_coverages",
            joinColumns = @JoinColumn(name = "policy_id"),
            inverseJoinColumns = @JoinColumn(name = "coverage_id")
    )
    private Set<Coverage> coverages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return policyId.equals(policy.policyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyId);
    }
}
