package org.skypro.list.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.list.employee.Employee;

import java.util.*;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private List<Employee> employees;

@Test
void DepartmentServiceIml(){}

    @BeforeEach
    void init() {
        employees = Arrays.asList(new Employee("Ivan", "Petrov", 1, 22_500),
                  new Employee("Vera", "Vasileva", 2, 34_6000),
                  new Employee("Marya", "Ivanova", 1, 42_100),
                  new Employee("Victor", "Kovrov", 2, 19_900));


    }

    @Test
    void getMaxSalary(){
        when(employeeService.getAllEmployees()).thenReturn(employees);
        double actual;
        actual = departmentService.getMaxSalaryEmployee(1);
        Assertions.assertEquals(42_100,actual);

    }
    @Test
    void getMinSalary(){
        when(employeeService.getAllEmployees()).thenReturn(employees);
        double actual = departmentService.getMinSalaryEmployee(2);
        Assertions.assertEquals(19_900,actual);
    }
    @Test
    void sum(){
        when(employeeService.getAllEmployees()).thenReturn(employees);
       double actual = departmentService.sumSalaryByDepartment(1);
       Assertions.assertEquals(64_600, actual);
    }
    @Test
    void getAllEmployeeByDepartment(){
        when(employeeService.getAllEmployees()).thenReturn(employees);
        List<Employee> result = departmentService.getAllEmployeeByDepartment(1);

        Assertions.assertEquals(2, result.size());
    }
    @Test
    void findAllEmployee(){
        when(employeeService.getAllEmployees()).thenReturn(employees);

        Map<Integer, List<Employee>> result = Collections.unmodifiableMap(departmentService.findAllEmployee());

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(2, result.get(1).size());
        Assertions.assertEquals(2, result.get(2).size());
    }


}