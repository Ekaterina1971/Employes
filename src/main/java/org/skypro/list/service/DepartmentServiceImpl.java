package org.skypro.list.service;

import org.skypro.list.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service

public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService =  employeeService;
    }


    public double getMaxSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .mapToDouble(Employee::getSalary)
                .max()
                .orElseThrow();

    }


    public double getMinSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .mapToDouble(Employee::getSalary)
                .min()
                .orElseThrow();
    }
    public double sumSalaryByDepartment(int departmentId) {
        double sum = 0.0;
        for (Employee emp : employeeService.getAllEmployees()) {
            if (emp.getDepartmentId() == departmentId) {
                double salary = emp.getSalary();
                sum += salary;
            }
        }
        return sum;
    }

    public List<Employee> getAllEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployee() {
        Map<Integer, List<Employee>> map = new HashMap<>();
        for (Employee employee : employeeService.getAllEmployees()) {
            map.computeIfAbsent(employee.getDepartmentId(), k -> new ArrayList<>()).add(employee);
        }
        return map;
    }

}







