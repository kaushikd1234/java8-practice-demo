package java8.flatmapdemo.dto;

import java.util.List;

public class User {

    private int empId;
    private String name;
    private String department;
    private double salary;

    private List<String> emails;

    public User(int empId, String name, String department, double salary, List<String> emails) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.emails = emails;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "User{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", emails=" + emails +
                '}';
    }
}

