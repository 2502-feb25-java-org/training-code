package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //@EnableDiscoveryClient -- just in case you do not want to tightly bind your app to Eureka, as other discovery services exist. like Consul, Zookeeper
public class App {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}


}
