package org.skypro.list.employee;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int departmentId;
    private double salary;

    public Employee(String firstName, String lastName, int departmentId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName) {
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

    public int getDepartmentId(){
       return departmentId;
    }

    public double getSalary(){
       return salary;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return departmentId == employee.departmentId &&
                Double.compare(salary, employee.salary) == 0
                && Objects.equals(lastName, employee.lastName)
                && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }

    @Override
        public String toString() {
         return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }

}
