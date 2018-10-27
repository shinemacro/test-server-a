package com.dovepay.test.server.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestServerAApplication {

	public static void main(String[] args) {
	    System.out.println("TestServerAApplication start...");
		SpringApplication.run(TestServerAApplication.class, args);
		System.out.println("TestServerAApplication run...");
	}
}
