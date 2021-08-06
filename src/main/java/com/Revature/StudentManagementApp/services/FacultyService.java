package com.Revature.StudentManagementApp.services;

import com.Revature.StudentManagementApp.exceptions.InvalidRequestException;
import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.repositories.FacultyRepository;

public class FacultyService {

    private FacultyRepository faculty_repo;


    public FacultyService(FacultyRepository faculty_repo){
        this.faculty_repo = faculty_repo;
    }

    public FacultyService() {

    }


    //TODO student register method AND FACULTY
    public Faculty register(Faculty new_user){
        System.out.println("Inside register");
        if (!isUserValid(new_user)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }
        return faculty_repo.save(new_user);
    }


    private boolean isUserValid(Faculty user) {
        if (user == null) return false;
        if (user.getUser().getLast_name() == null || user.getUser().getLast_name().trim().equals("")) return false;
        if (user.getUser().getEmail() == null || user.getUser().getEmail().trim().equals("")) return false;
        if (user.getUser().getUser_name() == null || user.getUser().getUser_name().trim().equals("")) return false;
        return user.getUser().getPassword() != null && !user.getUser().getPassword().trim().equals("");
    }


    public Faculty login(String username, String password) {
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid user credentials provided!");
        }

        return faculty_repo.findUserByCredentials(username, password);
    }
}
