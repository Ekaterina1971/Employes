package controller;

import org.skypro.list.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.DepartamentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departaments")
public class DepartamentController {
    private DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam("departamentId") int departamentId) {
        return departamentService.getMaxSalaryEmployee(departamentId);

    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam("departamentId") int departamentId) {
        return departamentService.getMinSalaryEmployee(departamentId);
    }

    @GetMapping("/all/by-department")
    public List<Employee> getAllEmployeeByDepartment(@RequestParam("departamentId") int departamentId) {
        return departamentService.getAllEmployeeByDepartment(departamentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departamentService.getAllEmployees();
    }
}



