package com.sohan.reactive.application.model;

import java.time.LocalDateTime;

public class EmployeeEvent {

    private Employee employee;
    private LocalDateTime dateTime;

    public EmployeeEvent() {

    }

    public EmployeeEvent(Employee employee, LocalDateTime dateTime) {
        this.employee = employee;
        this.dateTime = dateTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "EmployeeEvent{" +
                "employee=" + employee +
                ", dateTime=" + dateTime +
                '}';
    }
}
