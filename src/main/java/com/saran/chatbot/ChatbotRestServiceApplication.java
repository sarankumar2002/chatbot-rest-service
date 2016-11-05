package com.saran.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(Config.class)
public class ChatbotRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotRestServiceApplication.class, args);
	}
}
