package org.skypro.list;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
        static final int maxNumber = 7;
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Oleg", "Ivanov"),
                new Employee("Ivan", "Fedorov"),
                new Employee("Vera", "Vasileva"),
                new Employee("Fred", "Dobrov"),
                new Employee("Roman", "Barinov"),
                new Employee("Damir", "Kovrov")
        ));

        public Employee add(String firstName, String lastName){
            if(employees.size() >= maxNumber){
                throw new EmployeeStoragelsFullException("Превышен лимит сотрудников");
            }
            Employee employee = new Employee(firstName,lastName);
            if(employees.contains(employee)){
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
            }
            employees.add(employee);
            return employee;
        }
        public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException{
           //remove(firstName, lastName);
            if (firstName.contains(null) & lastName.contains(null)) {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
            employees.remove(employees);
            return null;
        }

        public Employee find(String firstName, String lastName) throws EmployeeNotFoundException{
            find(firstName, lastName);
            if(firstName.contains(null) & lastName.contains(null)) {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
            return (Employee) employees;
        }

}
