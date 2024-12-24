package org.skypro.list.controller;

import org.skypro.list.employee.Employee;
import org.skypro.list.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{id}/salary/max")
    public double getMaxSalaryEmployee(@RequestParam("department") int departmentId) {
        return departmentService.getMaxSalaryEmployee(departmentId);

    }
    @GetMapping("{id}/salary/sum")
    public double sumSalaryByDepartment(@RequestParam("department") int departmentId){
        return departmentService.sumSalaryByDepartment(departmentId);
    }

    @GetMapping("{id}/salary/min")
    public double getMinSalaryEmployee(@RequestParam("department") int departmentId) {
        return departmentService.getMinSalaryEmployee(departmentId);
    }
    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeeByDepartment(@RequestParam("department") int departmentId) {
        return (List<Employee>) departmentService.getAllEmployeeByDepartment(departmentId);
    }

    @GetMapping("/department/employees")
    public Map<Integer, List<Employee>> findAllEmployee() {
        return departmentService.findAllEmployee();
    }
}



