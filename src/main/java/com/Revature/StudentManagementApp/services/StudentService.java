package com.Revature.StudentManagementApp.services;

import com.Revature.StudentManagementApp.exceptions.InvalidRequestException;
import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.repositories.StudentRepository;

public class StudentService {

    private StudentRepository stu_repo;


    public StudentService(StudentRepository stu_repo){
        this.stu_repo = stu_repo;
    }

    public StudentService() {

    }


    //TODO student register method AND FACULTY
    public Student register(Student new_user){
            if (!isUserValid(new_user)) {

                throw new InvalidRequestException("Invalid user data provided!");
            }else
                System.out.println("inside regis");
                return stu_repo.save(new_user);
    }

    private boolean isUserValid(Student user) {
        if (user == null)return false;
        if (user.getUser().getLast_name() == null || user.getUser().getLast_name().trim().equals("")) return false;
        if (user.getUser().getEmail() == null || user.getUser().getEmail().trim().equals("")) return false;
        if (user.getUser().getUser_name() == null || user.getUser().getUser_name().trim().equals("")) return false;
        return user.getUser().getPassword() != null && !user.getUser().getPassword().trim().equals("");
    }



    public Student login(String username, String password) {
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid user credentials provided!");
        }

        return stu_repo.findUserByCredentials(username, password);
    }
}
