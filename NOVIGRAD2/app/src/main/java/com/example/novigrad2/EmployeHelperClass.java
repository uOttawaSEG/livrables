package com.example.novigrad2;

public class EmployeHelperClass {
    String name , LastName,  email , password;

    public EmployeHelperClass(String lastName, String name , String email , String password) {
        this.LastName = lastName;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public EmployeHelperClass() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
