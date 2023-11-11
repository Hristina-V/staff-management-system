package com.sirma.staff.managemen.system.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends BaseEntity implements Serializable {

    private String name;

    private LocalDate startDate;

    private String department;

    private String role;

    private double salary;

    private boolean isActive;

    public Employee(String name, LocalDate startDate, String department, String role, double salary) {
        this(0, name, startDate, department, role, salary);
    }

    public Employee(int id, String name, LocalDate startDate, String department, String role, double salary) {
        super(id);
        this.name = name;
        this.startDate = startDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
        isActive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + getId() +
                ", Name='" + name + '\'' +
                ", StartDate=" + startDate +
                ", Department='" + department + '\'' +
                ", Role='" + role + '\'' +
                ", Salary=" + salary +
                ", IsActive=" + isActive +
                '}';
    }
}
