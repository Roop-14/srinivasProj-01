package com.ticket_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MoviesServicesRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesServicesRegistryApplication.class, args);
	}

}
