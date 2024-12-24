package org.skypro.list.service;

import org.skypro.list.employee.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int departmentId, double salary);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    List<Employee> getAllEmployees();
}
