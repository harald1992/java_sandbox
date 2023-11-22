package com.harald.SpringCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// if more packages outside com.harald.SpringCore folder
// @SpringBootApplication(
// 		scanBasePackages={“com.harald.extraPackage”, “com.harald.packageTwo”} )
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
