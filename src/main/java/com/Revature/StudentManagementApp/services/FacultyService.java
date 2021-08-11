package com.Revature.StudentManagementApp.services;

import com.Revature.StudentManagementApp.exceptions.InvalidRequestException;
import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.repositories.FacultyRepository;
import com.Revature.StudentManagementApp.util.CurrentUser;

import javax.naming.AuthenticationException;

public class FacultyService {

    private final FacultyRepository faculty_repo;
    private final CurrentUser sesh;


    public FacultyService(FacultyRepository faculty_repo, CurrentUser sesh){

        this.faculty_repo = faculty_repo;
        this.sesh = sesh;
    }



    //TODO student register method AND FACULTY
    public Faculty register(Faculty new_user){

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
        Faculty faculty = faculty_repo.findUserByCredentials(username, password);


        if (faculty == null) {

            try {
                throw new AuthenticationException("Invalid user");
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }

        }


        sesh.setCurrentUserFaculty(faculty);
        return faculty;

    }

    public CurrentUser getSesh(){
        return sesh;
    }
}
