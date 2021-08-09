package com.Revature.StudentManagementApp.screens;


import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentScreen extends Screen{
    public StudentScreen(BufferedReader consoleReader, ScreenRouter router, StudentService studentService) {
        super("Student Screen", "/studentScreen", consoleReader, router);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Inside Student Screen");
        String menu = "\nWelcome to the student screen\n" +
                "1) Look up my information\n" +
                "2) Register for classes\n" +
                "3) Drop classes\n" +
                "4) Update user info\n" +
                "> ";

        System.out.println(menu);
        String userSelection = consoleReader.readLine();


    }
}
