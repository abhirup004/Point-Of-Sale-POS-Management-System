package com.jbs.posbe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosbeApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(PosbeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PosbeApplication.class, args);
		logger.info("PosbeApplication started successfully...");
		logger.info("Camelia Chowdhury - 2024-06-01");
		logger.info("Tania is the best programmer in the world!");
	}

}
