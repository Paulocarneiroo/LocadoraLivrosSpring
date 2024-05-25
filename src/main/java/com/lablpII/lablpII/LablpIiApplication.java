package com.lablpII.lablpII;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LablpIiApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(LablpIiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Application is running...");
	}
}
