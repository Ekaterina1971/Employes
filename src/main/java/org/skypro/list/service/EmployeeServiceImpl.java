package org.skypro.list.service;

import org.skypro.list.employee.Employee;
import org.skypro.list.exception.EmployeeAlreadyAddedException;
import org.skypro.list.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        // Инициализируем и наполняем employees при создании экземпляра класса
        employees = new HashMap<>();
        initializeEmployees();
    }

    // Метод для инициализации данных
    private void initializeEmployees() {
        add("Ivan", "Petrov", 1, 22_500);
        add("Vera", "Vasileva", 2, 34_546);
        add("Marya", "Ivanova", 3, 42_100);
        add("Victor", "Kovrov", 4, 19_900);
        add("Pavel", "Vasilev", 5, 54_500);
        add("Vlad", "Fedorov", 1, 24_700);
        add("Olga", "Voronova", 2, 31_600);
        add("Timur", "Baskov", 3, 40_800);
        add("Damir", "Polkov", 4, 17_400);
        add("Stepan", "Sidorov", 5, 39_500);
    }

    @Override
    public Employee add(String firstName, String lastName, int departmentId, double salary) {
        Employee newEmployee = new Employee(firstName, lastName, departmentId, salary);
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> getAllEmployees() {

        return new ArrayList<>(employees.values());
    }

    private String getKey(String firstName, String lastName) {

        return (firstName + " " + lastName).toLowerCase();
    }
}


