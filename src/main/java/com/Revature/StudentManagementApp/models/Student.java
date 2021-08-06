package com.Revature.StudentManagementApp.models;

import com.Revature.StudentManagementApp.util.IdGenerator;

public class Student {


    private int student_Id;
    private String Major;
    private SchoolUser user;


    public Student(){

    }


    public Student(String fn, String ln, String email, String username, String password) {
        this.user = new SchoolUser(fn, ln, email, username, password);
    }


    public int getStudent_Id() {
        return student_Id;
    }

    public String toFile() {

        StringBuilder builder = new StringBuilder();
        builder.append(student_Id).append(":")
                .append(user.getFirst_name()).append(" ").append(user.getLast_name()).append(":")
                .append(user.getEmail()).append(":")
                .append(user.getUser_name()).append(":")
                .append(user.getPassword()).append("\n");

        return builder.toString();
    }


    @Override
    public String toString() {
        return "Student{" +
                "student_Id=" + student_Id +
                ", Major='" + Major + '\'' +
                ", user=" + user +
                '}';
    }

    public void setStudent_Id(int student_Id) {
        this.student_Id = student_Id;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        this.Major = major;
    }

    public SchoolUser getUser() {
        return user;
    }

    public void setUser(SchoolUser user) {
        this.user = user;
    }
}
