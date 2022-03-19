package com.company;

import java.io.Serializable;

public class Employee implements Serializable {
    private String employeeName;
    private int yrsOfExperience;
    private double salary;
    private int employeeID;

    public Employee(String employeeName, int yrsOfExperience, double salary, int employeeID){
        this.employeeName = employeeName;
        this.yrsOfExperience = yrsOfExperience;
        this.salary = salary;
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getYrsOfExperience() {
        return yrsOfExperience;
    }

    public double getSalary() {
        return salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setYrsOfExperience(int yrsOfExperience) {
        this.yrsOfExperience = yrsOfExperience;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee name: '" + employeeName + '\'' +
                ", years of experience: " + yrsOfExperience +
                ", salary: " + salary +
                ", employee ID: " + employeeID;
    }
}
