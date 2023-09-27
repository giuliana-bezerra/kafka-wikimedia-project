package com.example.kafkawikimediaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// https://stream.wikimedia.org/v2/stream/recentchange
@SpringBootApplication
@EnableScheduling
public class KafkaWikimediaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaWikimediaProjectApplication.class, args);
	}
}
