package com.example.dbtablesharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
		"com.example.dbtablesharding.model,com.example.dbtablesharding.controller,com.example.dbtablesharding.service" })
@SpringBootApplication
@EnableJpaRepositories()
public class DbTableShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbTableShardingApplication.class, args);
	}

}
