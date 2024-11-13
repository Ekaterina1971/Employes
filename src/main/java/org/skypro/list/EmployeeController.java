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














//public class EmployeeController {
  //  private final EmployeeService employeeService;
    //public EmployeeController(EmployeeService employeeService){
      //  this.employeeService = employeeService;
   // }
   // @GetMapping("/add")
  //  public Employee addEmployee(@RequestParam("firstName") String firstName,
       //                 @RequestParam("lastName") String lastName) {
    //    return employeeService.add(firstName, lastName);
  //  }
        // employeeService.add(firstName, lastName);
    // catch (EmployeeStoragelsFullException employeeStoragelsFullException){
      // System.out.println("Превышен лимит сотрудников");
    //catch (EmployeeAlreadyAddedException employeeAlreadyAddedException) {
       // System.out.println("Такой сотрудник уже существует");

    //Employee employee = new Employee(firstName, lastName);
   // return employee;

//@GetMapping("/remove")
  //  public Employee removeEmployee(@RequestParam("firstName") String firstName,
          //                 @RequestParam("lastName") String lastName) {
 //   return employeeService.remove(firstName, lastName);
 //   }
    //try {
      //  employeeService.remove(firstName, lastName);
   // } catch (EmployeeNotFoundException employeeNotFoundException) {
       // System.out.println("Сотрудник не найден");
   // }   System.out.println("Сотрудник удален");
   // return null;

//@GetMapping("/find")
  //  public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
      //  return service.find(firstName, lastName);
  //  }
//@GetMapping("/allEmployees")
  //  public List<Employee> getAllEmployees() {
     //   return employeeService.getAll();
   // }

       // try {
           // employeeService.find(firstName, lastName);
      //  } catch (EmployeeNotFoundException employeeNotFoundException) {
          //  System.out.println("Сотрудник не найден");
       // } return firstName + lastName;











