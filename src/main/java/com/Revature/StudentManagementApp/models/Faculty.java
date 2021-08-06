package com.Revature.StudentManagementApp.models;

import com.Revature.StudentManagementApp.util.IdGenerator;

public class Faculty {

    private int Id;
    private Float Salary;
    private String department;
    private SchoolUser user;


    Faculty(){

    }
    public Faculty(String fn, String ln, String email, String username, String password) {
        super();
        this.Id = IdGenerator.getRandomId();
        this.user = new SchoolUser(fn, ln, email, username, password);
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
                "Id=" + Id +
                ", department='" + department + '\'' +
                ", User=" + user +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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
        user = user;
    }
}
