package org.skypro.list.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.list.employee.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    List<Employee> employees = Arrays.asList(new Employee("Ivan", "Petrov", 1, 22_500),
            new Employee("Vera", "Vasileva", 2, 34_600),
            new Employee("Marya", "Ivanova", 1, 42_100),
            new Employee("Victor", "Kovrov", 2, 19_900));

    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void getMaxSalaryEmployee(){
        Employee actual = departmentService.getMaxSalaryEmployee(1);
        assertEquals(42_100,actual);
        //Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
       // Employee result = departmentService.getMaxSalaryEmployee(1);

      //  Assertions.assertTrue(result.toString());
      //  Assertions.assertEquals("Marya", result.get().getFirstName());
    }
    @Test
    void getMinSalaryEmployee(){
        Employee actual = departmentService.getMinSalaryEmployee(2);
        assertEquals(19_900,actual);
    }
    @Test
    void sumSalaryByDepartment(){
       double actual = departmentService.sumSalaryByDepartment(1);
       assertEquals(67_700, actual);
    }



}