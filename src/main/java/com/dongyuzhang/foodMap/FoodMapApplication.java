package com.dongyuzhang.foodMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodMapApplication {

	public static void main(String[] args) {
	    final SpringApplication application = new SpringApplication(FoodMapApplication.class);
	    application.setAddCommandLineProperties(false);
		application.run(args);
	}
}
