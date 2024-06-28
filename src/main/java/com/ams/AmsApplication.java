package com.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.ams.*"})
//@EnableJpaRepositories("com.ams.*")
//@EntityScan("com.ams.*")
//@ComponentScan(basePackages = {"com.ams"})
public class AmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AmsApplication.class, args);
	}
}
