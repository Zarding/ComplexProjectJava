package com.zar.JavaServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class JavaServerApplication {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CalendarRepository calendarRepository;

	public static void main(String[] args) {
		SpringApplication.run(JavaServerApplication.class, args);
	}

}
