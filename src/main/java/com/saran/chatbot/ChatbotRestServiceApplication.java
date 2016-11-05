package com.saran.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
//@Import(Config.class)
public class ChatbotRestServiceApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
       return application.sources(ChatbotRestServiceApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(ChatbotRestServiceApplication.class, args);
	}
}
