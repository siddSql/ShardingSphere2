package com.example.dbtablesharding;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AppConfiguration {

	@Autowired
	DataSource dataSource;

	@Bean
	@ConfigurationProperties(prefix = "spring.shardingsphere.datasource.ds0")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		// JpaVendorAdapteradapter can be autowired as well if it's configured in
		// application properties.
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		// Add package to scan for entities.
		factory.setPackagesToScan("com.example.mySqlTest.model");
		factory.setDataSource(dataSource);
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.shardingsphere.datasource.ds1")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

}