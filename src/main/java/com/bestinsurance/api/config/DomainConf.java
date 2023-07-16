package com.bestinsurance.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.bestinsurance.api.domain")
@EnableJpaRepositories("com.bestinsurance.api.repository")
public class DomainConf {
}
