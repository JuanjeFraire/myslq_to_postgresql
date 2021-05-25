package com.ehsaniara.multidatasource.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Setter
@Getter
@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties("spring.datasource-read.hikari")
public class HikariReadProperties {

    private String poolName;

    private Integer minimumIdle;

    private Integer maximumPoolSize;

    private Integer idleTimeout;
}
