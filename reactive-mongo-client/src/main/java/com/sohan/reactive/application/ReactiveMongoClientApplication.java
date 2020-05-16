package com.sohan.reactive.application;

import com.sohan.reactive.application.model.Employee;
import com.sohan.reactive.application.model.EmployeeEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveMongoClientApplication {

	@Bean
	public WebClient webClient() {
		return WebClient.create("http://localhost:8051/resource/rest/employee");
	}

	@Bean
	public CommandLineRunner commandLineRunner(WebClient webClient) {
		return strings -> {
			webClient
					.get()
					.uri("/")
					.retrieve()
					.bodyToFlux(Employee.class)
					.filter(employee -> employee.getName().equals("Tom"))
			.flatMap(employee ->
				webClient
						.get()
						.uri("/{id}/events", employee.getId())
						.retrieve()
						.bodyToFlux(EmployeeEvent.class)
					)
					.subscribe(System.out::println);

			for (int i = 0; i < 200; i++)
				System.out.println("Printing " + i);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoClientApplication.class, args);
	}

}
