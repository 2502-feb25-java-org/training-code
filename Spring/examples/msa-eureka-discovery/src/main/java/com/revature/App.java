package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication //@SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
@EnableEurekaServer //allows app to run as eureka server
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

// check this link out: https://www.tutorialspoint.com/spring_boot/spring_boot_eureka_server.htm
	
	
	
}
