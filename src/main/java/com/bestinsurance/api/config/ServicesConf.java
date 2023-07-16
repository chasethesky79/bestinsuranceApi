package com.bestinsurance.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.bestinsurance.api.services, com.bestinsurance.api.rest")
public class ServicesConf {
}
