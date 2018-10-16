package com.sid.SpringBootRestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sid.spring")
public class SpringBootRestMain {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootRestMain.class, args);

	}

}
