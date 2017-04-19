package com.itransition.lyubin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatebaseConfig {

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show-sql}")
    private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

    @Value("${hibernate.driverClassName}")
    private String driverClassName;
    @Value("${hibernate.url}")
    private String url;
    @Value("${hibernate.username}")
    private String username;
    @Value("${hibernate.password}")
    private String password;

    @Value("${entitymanager.packagesToScan}")
    private String packagesToScan;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource);

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan(
                packagesToScan);

        // Vendor adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Hibernate properties
        Properties additionalProperties = new Properties();
        additionalProperties.put(
                "hibernate.dialect",
                hibernateDialect);
        additionalProperties.put(
                "hibernate.show_sql",
                hibernateShowSql);
        additionalProperties.put(
                "hibernate.hbm2ddl.auto",
                hibernateHbm2ddlAuto);
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }

    /**
     * Declare the transaction manager.
     */

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                this.entityManagerFactory().getObject());
        return transactionManager;
    }


}