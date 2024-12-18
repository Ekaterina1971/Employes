package org.skypro.list.controller;


import org.skypro.list.employee.Employee;
import org.skypro.list.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
       this.service = service;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departamentId, @RequestParam double salary) {
        return service.add(firstName, lastName, departamentId, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int departamentId, @RequestParam double salary) {
        return service.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName){
        return service.find(firstName, lastName);
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
}
























