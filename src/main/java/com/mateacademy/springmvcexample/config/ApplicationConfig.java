package com.mateacademy.springmvcexample.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

@Configuration
@EnableJpaRepositories("com.mateacademy.springmvcexample.repository")
@ComponentScan("com.mateacademy.springmvcexample")
@PropertySource("application.properties")
@EntityScan("com.mateacademy.springmvcexample.model")
public class ApplicationConfig {
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${driver}")
    private String driver;
    @Value("${password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${ddl-auto}")
    private String ddlAuto;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
        emFactory.setDataSource((dataSource()));
        emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", dialect);
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
        emFactory.setJpaProperties(jpaProperties);
        emFactory.setPackagesToScan("com.mateacademy.springmvcexample.model");
        return emFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
