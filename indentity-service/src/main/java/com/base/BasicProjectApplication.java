package com.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BasicProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicProjectApplication.class, args);
	}

}
