package org.skypro.list.service;

import org.skypro.list.employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getMaxSalaryEmployee(int departmentId);
    Employee getMinSalaryEmployee(int departmentId);
    double sumSalaryByDepartment(int departmentId);
    List<Employee> getAllEmployeeByDepartment(int departmentId);
    Map<Integer, List<Employee>> findAllEmployee();

}
