package com.htdp1.integrhttpspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:*http-outbound-gateway.xml")
public class IntegrHttpSpringApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(IntegrHttpSpringApplication.class, args);
	}

}
