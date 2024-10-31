package org.skypro.list;

public class EmployeeNotFoundException extends RuntimeException{
   public String firstName;
   public String lastName;

   public EmployeeNotFoundException(String firstName, String lastName){
       super("%s %s".formatted(firstName,lastName));
       this.firstName = firstName;
       this.lastName = lastName;
   }

    public EmployeeNotFoundException(String сотрудникНеНайден) {
    }
}
