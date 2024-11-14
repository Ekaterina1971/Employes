package org.skypro.list;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int departamentId, double salary);
    Employee remove(String firstName, String lastName,int departamentId, double salary);
    Employee find(String firstName, String lastName,int departamentId, double salary);
    Collection<Employee> getAllEmployees();
}
