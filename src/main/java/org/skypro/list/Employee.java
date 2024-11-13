package org.skypro.list;

import jakarta.annotation.PostConstruct;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int departamentId;
    private double salary;

    public Employee(String firstName, String lastName, int departamentId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departamentId = departamentId;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return firstName + lastName;
    }

    public int getDepartamentId(){
        return departamentId;
    }

    public double getSalary(){
        return salary;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return departamentId == employee.departamentId &&
                Double.compare(salary, employee.salary) == 0
                && Objects.equals(lastName, employee.lastName)
                && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departamentId, salary);
    }

    @Override
        public String toString() {
       // return firstName + lastName + " отдел: " + departamentId + ", зарплата: " + salary;
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departamentId +
                ", salary=" + salary +
                '}';
    }

}
