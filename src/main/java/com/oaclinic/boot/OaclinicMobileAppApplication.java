package com.oaclinic.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.oaclinic")
@EntityScan("com.oaclinic")
@EnableJpaRepositories("com.oaclinic")
public class OaclinicMobileAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OaclinicMobileAppApplication.class, args);
	}
}
