package com.example.dhan.hackernews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HackernewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackernewsApplication.class, args);
	}

}
