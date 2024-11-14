package org.skypro.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departamentId, @RequestParam double salary) {
        return service.add(firstName, lastName, departamentId, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int departamentId, @RequestParam double salary) {
        return service.remove(firstName, lastName,departamentId, salary);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int departamentId, @RequestParam double salary) {
        return service.find(firstName, lastName,departamentId, salary);
    }

    @GetMapping("/findAll")
    public Collection<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
}
























