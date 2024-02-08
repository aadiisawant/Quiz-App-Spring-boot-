package com.sunshine.quizservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuestionService1Application {

	public static void main(String[] args) {
		SpringApplication.run(QuestionService1Application.class, args);
	}

}
