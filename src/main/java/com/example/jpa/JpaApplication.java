package com.example.jpa;

import com.example.jpa.examples.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {
	@Autowired
	StartJPA startJPA;
	@Autowired
	EntityPersist entityPersist;
	@Autowired
	EntityUpdate entityUpdate;
	@Autowired
	Detach detach;
	@Autowired
	Clear clear;
	@Autowired
	Close close;
	@Autowired
	Merge merge;
	@Autowired
	IdentityStrategy identityStrategy;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			identityStrategy.run();
		};
	}
}
