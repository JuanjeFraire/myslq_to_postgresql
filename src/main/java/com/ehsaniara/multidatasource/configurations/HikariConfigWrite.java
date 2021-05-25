package com.ehsaniara.multidatasource.configurations;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.util.Properties;

public class HikariConfigWrite extends HikariConfig {

    protected final HikariWriteProperties hikariWriteProperties;

    protected final String PERSISTENCE_UNIT_NAME = "write";

    protected final Properties JPA_WRITE_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        put("hibernate.hbm2ddl.auto", "create");
        put("hibernate.ddl-auto", "create");
        put("show-sql", "true");
    }};

    protected HikariConfigWrite(HikariWriteProperties hikariWriteProperties) {
        this.hikariWriteProperties = hikariWriteProperties;
        setPoolName(this.hikariWriteProperties.getPoolName());
        setMinimumIdle(this.hikariWriteProperties.getMinimumIdle());
        setMaximumPoolSize(this.hikariWriteProperties.getMaximumPoolSize());
        setIdleTimeout(this.hikariWriteProperties.getIdleTimeout());
    }
}
