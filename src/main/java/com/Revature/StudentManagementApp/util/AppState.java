package com.Revature.StudentManagementApp.util;

import com.Revature.StudentManagementApp.repositories.FacultyRepository;
import com.Revature.StudentManagementApp.repositories.StudentRepository;
import com.Revature.StudentManagementApp.screens.*;
import com.Revature.StudentManagementApp.services.FacultyService;
import com.Revature.StudentManagementApp.services.StudentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    static private boolean appRunning;
    private final ScreenRouter router;


    //conctructor
    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        // Create app components
        StudentRepository userRepo = new StudentRepository();
        StudentService studentService = new StudentService(userRepo);

        FacultyRepository facRepo = new FacultyRepository();
        FacultyService facultyService = new FacultyService(facRepo);







        router.addScreen(new WelcomeScreen(consoleReader, router))
                .addScreen(new LoginScreen(consoleReader, router, studentService))
                .addScreen(new RegisterScreen(consoleReader, router, studentService, facultyService))
                .addScreen(new StudentScreen(consoleReader, router, studentService))
                .addScreen(new FacultyScreen(consoleReader, router, studentService));

    }

    static public void stoprunning(){
        appRunning = false;
    }

    public void startup() {
        router.navigate("/welcome");

        while (appRunning) {
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
