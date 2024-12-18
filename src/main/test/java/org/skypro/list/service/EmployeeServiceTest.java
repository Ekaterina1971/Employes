package org.skypro.list.service;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skypro.list.employee.Employee;

import java.util.Map;

public class EmployeeServiceTest {
    @Mock
    private Map<String, Employee> employeeMap;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void add(){
        String firstName = "Ivan";
        String lastName = "Petrov";
        int departmentId = 1;
        double salary = 22_500;
        Mockito.when(employeeMap.containsKey(Mockito.anyString())).thenReturn(false);
        Mockito.when(employeeMap.put(Mockito.anyString(), Mockito.any(Employee.class))).thenReturn(null);

        Employee result = employeeService.add(firstName, lastName, departmentId, salary);

        Assertions.assertEquals(firstName, result.getFirstName());
        Assertions.assertEquals(lastName, result.getLastName());
        Assertions.assertEquals(departmentId, result.getDepartmentId());
        Assertions.assertEquals(salary, result.getSalary());

    }
    @Test
    void remove() {
        String firstName = "Ivan";
        String lastName = "Petrov";
        Mockito.when(employeeMap.remove(Mockito.anyString())).thenReturn(new Employee(firstName, lastName));

        Employee result = employeeService.remove(firstName, lastName);

        Assertions.assertEquals(firstName, result.getFirstName());
        Assertions.assertEquals(lastName, result.getLastName());

    }
    @Test
    void find() {
        String firstName = "Ivan";
        String lastName = "Petrov";
        int departmentId = 1;
        double salary = 22_500;
        Mockito.when(employeeMap.containsKey(Mockito.anyString())).thenReturn(true);
        Mockito.when(employeeMap.get(Mockito.anyString())).thenReturn(new Employee(firstName, lastName, departmentId, salary));

        Employee result = employeeService.find(firstName, lastName);

        Assertions.assertEquals(firstName, result.getFirstName());
        Assertions.assertEquals(lastName, result.getLastName());
        Assertions.assertEquals(departmentId, result.getDepartmentId());
        Assertions.assertEquals(salary, result.getSalary());

    }
    @Test
    public void testFind_NotFound() {
        String firstName = "Ivan";
        String lastName = "Petrov";

        Mockito.when(employeeMap.containsKey(Mockito.anyString())).thenReturn(false);

        employeeService.find(firstName, lastName);
    }


}




