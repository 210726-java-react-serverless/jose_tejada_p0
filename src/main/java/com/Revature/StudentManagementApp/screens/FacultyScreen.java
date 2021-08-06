package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class FacultyScreen extends Screen{

    //TODO add userservice and registration service after completeing


    public FacultyScreen(BufferedReader consoleReader, ScreenRouter router, StudentService studentService) {
        super("Faculty Screen", "facultyScreen", consoleReader, router);
    }



    @Override
    public void render() throws Exception {

        System.out.println("Inside Faculty Screen");

    }
}
