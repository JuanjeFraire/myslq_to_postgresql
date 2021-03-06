package com.ehsaniara.multidatasource.configurations;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.util.Properties;

public class HikariConfigRead extends HikariConfig {

    protected final HikariReadProperties hikariReadProperties;

    protected final String PERSISTENCE_UNIT_NAME = "read";

    protected final Properties JPA_READ_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        put("hibernate.hbm2ddl.auto", "update");
        put("hibernate.ddl-auto", "update");
        put("show-sql", "true");
    }};

    protected HikariConfigRead(HikariReadProperties hikariReadProperties) {
        this.hikariReadProperties = hikariReadProperties;
        setPoolName(this.hikariReadProperties.getPoolName());
        setMinimumIdle(this.hikariReadProperties.getMinimumIdle());
        setMaximumPoolSize(this.hikariReadProperties.getMaximumPoolSize());
        setIdleTimeout(this.hikariReadProperties.getIdleTimeout());
    }
}
