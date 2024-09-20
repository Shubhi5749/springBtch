package com.spring.batch.demo.springDemo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan({"com.spring.*"})
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
