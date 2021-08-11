package com.Revature.StudentManagementApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Faculty {


    private String Id;
    private Float Salary;
    private String department;
    private SchoolUser user;


    public Faculty(){

    }
    public Faculty(float salary, String department, String fn, String ln, String dob, String phone, String username, String password, String email, Address address) {
        this.Salary = salary;
        this.department = department;
        this.user = new SchoolUser(fn, ln, dob, phone, username,password, email, address);
    }


    public String toFile() {

        StringBuilder builder = new StringBuilder();
        builder.append(Id).append(":")
                .append(user.getFirst_name()).append(" ").append(user.getLast_name()).append(":")
                .append(user.getEmail()).append(":")
                .append(user.getUser_name()).append(":")
                .append(user.getPassword()).append("\n");

        return builder.toString();
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "Id='" + Id + '\'' +
                ", Salary=" + Salary +
                ", department='" + department + '\'' +
                ", user=" + user +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public Float getSalary() {
        return Salary;
    }

    public void setSalary(Float salary) {
        this.Salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public SchoolUser getUser() {
        return user;
    }

    public void setUser(SchoolUser user) {
        this.user = user;
    }
}
