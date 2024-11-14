package service;

import org.skypro.list.Employee;
import org.skypro.list.EmployeeService;
import org.skypro.list.EmployeeServiceMapImplementation;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartamentService {
    private EmployeeService employeeService;

    public DepartamentService(org.skypro.list.EmployeeService employeeService) {
        this.employeeService =  new EmployeeServiceMapImplementation();
    }
    public Employee getMaxSalaryEmployee(int departamentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartamentId() == departamentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getMinSalaryEmployee(int departamentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartamentId() == departamentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public List<Employee> getAllEmployeeByDepartment(int departamentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartamentId() == departamentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees().stream()
        .collect(Collectors.groupingBy(Employee::getDepartamentId));
    }
}




