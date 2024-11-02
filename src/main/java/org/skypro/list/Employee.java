package org.skypro.list;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int id;

    public Employee(String fistName, String lastName){
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getId(){
        return id;
    }
    public String setFistName(){
        return firstName;
    }
    public String setLastName(){
        return lastName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId();
    }
    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return firstName + lastName;
    }
}
