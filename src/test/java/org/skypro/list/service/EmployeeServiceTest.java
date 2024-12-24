package org.skypro.list.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skypro.list.employee.Employee;
import org.skypro.list.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest{

    private Map<String, Employee> employeeMap;

    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void add(){
        Employee expected = new Employee("Ivan", "Kotov", 1, 29_500);
        assertEquals( 0, employeeService.getAllEmployees().size());
        assertFalse(employeeService.getAllEmployees().contains(expected));
        Employee actual = employeeService.add("Ivan","Kotov",1, 29_500);

        assertEquals(expected, actual);
        assertEquals(1, employeeService.getAllEmployees().size());
        assertTrue(employeeService.getAllEmployees().contains(expected));

    }
    @Test
    public void addNew(){
        Employee actual = employeeService.add("Ivan","Kotov",1, 29_500);
        assertTrue(employeeService.getAllEmployees().contains(actual));
        assertThrows(RuntimeException.class,
                () -> employeeService.add("Ivan","Kotov",1,29_500));
    }


    @Test
    public void find() {
        Employee actual = employeeService.add("Ivan", "Kotov",1,29_500);

        assertEquals(actual,employeeService.find("Ivan","Kotov"));
    }


    @Test
    void remove() {
        Employee expected = employeeService.add("Ivan", "Kotov",1,29_500);
        assertTrue(employeeService.getAllEmployees().contains(expected));
        assertEquals(1,employeeService.getAllEmployees().size());

        Employee removeEmployee = employeeService.remove(expected.getFirstName(), expected.getLastName());
        assertEquals(expected, removeEmployee);
        assertFalse(employeeService.getAllEmployees().contains(expected));
        assertEquals(0,employeeService.getAllEmployees().size());


    }

    @Test
    public void testFind_NotFound() {

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.find("Nikolai", "Sergeerv");
        });

    }
    @Test
    public void shouldReturnAllEmployees(){
        Employee employee1 = employeeService.add("Ivan","Kotov",1,29_500);
        Employee employee2 = employeeService.add("Ivan","Petrov",1,33_200);
        Collection<Employee> expected = List.of(employee2, employee1);
        Collection<Employee> actual = employeeService.getAllEmployees();
        assertIterableEquals(expected,actual);
    }

}


