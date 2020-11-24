package com.hashan.cat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatCrudApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/rest/v2");
		SpringApplication.run(CatCrudApplication.class, args);
		System.out.println("CAT APP");
	}

}
