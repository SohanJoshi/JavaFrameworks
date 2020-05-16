package com.sohan.reactive.application.resource;

import com.sohan.reactive.application.model.Employee;
import com.sohan.reactive.application.model.EmployeeEvent;
import com.sohan.reactive.application.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@RestController
@RequestMapping("/resource/rest/employee")
public class EmployeeResource {

    private EmployeeRepository employeeRepository;

    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable("id") String id) {
        return employeeRepository.findById(id);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEvent> getEvents(@PathVariable("id") String id) {
        return employeeRepository.findById(id)
                .flatMapMany( employee -> {
                   Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));

                   Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(
                           Stream.generate(() -> new EmployeeEvent(employee, LocalDateTime.now())));

                   return Flux.zip(interval, employeeEventFlux, (k, v) -> v);
                });
    }
}
