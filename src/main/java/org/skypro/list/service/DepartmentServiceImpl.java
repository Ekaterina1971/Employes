package org.skypro.list.service;

import jakarta.annotation.PostConstruct;
import org.skypro.list.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService =  employeeService;
    }
    public Employee getMaxSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }


    public Employee getMinSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Collection<Employee> getAllEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployee() {
        return employeeService.getAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

}







