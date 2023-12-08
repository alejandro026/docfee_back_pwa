package com.docfee.admin.utng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdminDocfeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminDocfeeApplication.class, args);
	}

}
