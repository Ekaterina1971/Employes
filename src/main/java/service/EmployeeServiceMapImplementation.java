package service;

import org.skypro.list.Employee;
import org.skypro.list.EmployeeAlreadyAddedException;
import org.skypro.list.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceMapImplementation implements EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeServiceMapImplementation() {
        this.employees = new HashMap<>();
    }
    public static void initializeEmployees(){
        Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
        employees.put(1, new Employee("Ivan", "Petrov", 1, 22_500));
        employees.put(2, new Employee("Vera", "Vasileva", 2, 34_546));
        employees.put(3, new Employee("Marya", "Ivanova", 3, 42_100));
        employees.put(4, new Employee("Victor", "Kovrov", 4, 19_900));
        employees.put(5, new Employee("Pavel", "Vasilev", 5, 54_500));
        employees.put(6, new Employee("Vlad", "Fedorov", 1, 24_700));
        employees.put(7, new Employee("Olga", "Voronova", 2, 31_600));
        employees.put(8, new Employee("Timur", "Baskov", 3, 40_800));
        employees.put(9, new Employee("Damir", "Polkov", 4, 17_400));
        employees.put(10, new Employee("Stepan", "Sidorov", 5, 39_500));
    }
    @Override
    public Employee add(String firstName, String lastName,int departamentId, double salary) {
        Employee employee = new Employee(firstName, lastName, departamentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName,int departamentId, double salary) {
        Employee employee = new Employee(firstName, lastName, departamentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName,int departamentId, double salary) {
        Employee employee = new Employee(firstName, lastName, departamentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}


