package com.parser.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.parser")
@SpringBootApplication
public class StringParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringParserApplication.class, args);
	}
}
