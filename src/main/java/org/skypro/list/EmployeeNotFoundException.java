package org.skypro.list;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason ="Not found")
public class EmployeeNotFoundException extends RuntimeException{
   public String firstName;
   public String lastName;

   public EmployeeNotFoundException(String firstName, String lastName){
       super();
       this.firstName = firstName;
       this.lastName = lastName;
   }

    public EmployeeNotFoundException(String сотрудникНеНайден) {
    }
}
