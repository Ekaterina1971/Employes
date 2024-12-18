package org.skypro.list.service;

import org.skypro.list.employee.Employee;
import org.skypro.list.exception.EmployeeAlreadyAddedException;
import org.skypro.list.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        add("Vera", "Vasileva", 2, 34_600);
        add("Marya", "Ivanova", 1, 42_100);
        add("Victor", "Kovrov", 2, 19_900);

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


