package org.skypro.list;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Already is added")
public class EmployeeAlreadyAddedException extends RuntimeException{
    public String firstName;
    public String lastName;

    public EmployeeAlreadyAddedException(String firstName, String lastName){
        super("%s %s".formatted(firstName,lastName));
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public EmployeeAlreadyAddedException(String такойСотрудникУжеСуществует) {
    }
}
