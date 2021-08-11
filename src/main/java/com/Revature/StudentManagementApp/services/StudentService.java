package com.Revature.StudentManagementApp.services;

import com.Revature.StudentManagementApp.exceptions.InvalidRequestException;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.repositories.StudentRepository;
import com.Revature.StudentManagementApp.util.CurrentUser;

import javax.naming.AuthenticationException;

public class StudentService {

    private final StudentRepository stu_repo;
    private final CurrentUser sesh;


    public StudentService(StudentRepository stu_repo, CurrentUser sesh){

        this.stu_repo = stu_repo;
        this.sesh = sesh;
    }




    //TODO student register method AND FACULTY
    public Student register(Student new_user){

            if (!isUserValid(new_user)) {
                throw new InvalidRequestException("Invalid user data provided!");
            }else
                return stu_repo.save(new_user);
    }

    public boolean isUserValid(Student user) {
        if (user == null)return false;
        if (user.getUser().getLast_name() == null || user.getUser().getLast_name().trim().equals("")) return false;
        if (user.getUser().getEmail() == null || user.getUser().getEmail().trim().equals("")) return false;
        if (user.getUser().getUser_name() == null || user.getUser().getUser_name().trim().equals("")) return false;
        return user.getUser().getPassword() != null && !user.getUser().getPassword().trim().equals("");
    }



    public Student login(String username, String password)  {


        Student student = stu_repo.findUserByCredentials(username, password);

        if (student == null) {
            try {
                throw new AuthenticationException("Invalid user");
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }

        }

        sesh.setCurrentUserStudent(student);


        return student;
    }

    public CurrentUser getSesh(){
        return sesh;
    }
}
