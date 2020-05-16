package com.sohan.reactive.application;

import com.sohan.reactive.application.model.Employee;
import com.sohan.reactive.application.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveSpringMongoDemoApplication {

	@Bean
	CommandLineRunner initializeEmployees(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository
					.deleteAll()
					.subscribe(null, null, () ->
									Stream.of(
											new Employee(UUID.randomUUID().toString(), "John", 25000L),
			 								new Employee(UUID.randomUUID().toString(), "John", 35000L),
											new Employee(UUID.randomUUID().toString(), "Tom", 32000L)
									)
									.forEach(employee -> {
										employeeRepository
												.save(employee)
										.subscribe(System.out::println);

									})
							);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringMongoDemoApplication.class, args);
	}

}
