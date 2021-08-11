package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.services.RegistrationService;
import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class RegisteredCoursesScreen extends Screen {
    private final RegistrationService registrationService;
    private final StudentService studentService;

    public RegisteredCoursesScreen(BufferedReader consoleReader, ScreenRouter router, RegistrationService registrationService, StudentService studentService) {
        super("Registered Clases", "/registeredClasses", consoleReader, router);
        this.registrationService = registrationService;
        this.studentService = studentService;

    }



    @Override
    public void render() throws Exception {

        System.out.println("\n======== Your Classes ========");
        System.out.println("==============================\n");
        Student Stu = studentService.getSesh().getCurrentUserStudent();

        registrationService.coursesRegisteredTo(Stu.getUser().getUser_name());
        System.out.println("\n==============================\n");
        router.navigate("/studentScreen");




    }
}
