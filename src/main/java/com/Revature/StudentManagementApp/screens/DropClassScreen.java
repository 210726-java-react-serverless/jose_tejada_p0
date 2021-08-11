package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.services.RegistrationService;
import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class DropClassScreen extends Screen {

    private final RegistrationService registrationService;
    private final StudentService studentService;

    public DropClassScreen(BufferedReader consoleReader, ScreenRouter router, RegistrationService registrationService, StudentService studentService) {
        super("Drop Screen", "/dropScreen", consoleReader, router);
        this.registrationService = registrationService;
        this.studentService  = studentService;
    }



    @Override
    public void render() throws Exception {
        Student stu = studentService.getSesh().getCurrentUserStudent();

        registrationService.coursesRegisteredTo(stu.getUser().getUser_name());
        System.out.println("\n--Type in the course code for the class you would like to drop--\n" +
                ">");
        String course_code = consoleReader.readLine();
        registrationService.unregisterFromCourse(course_code, stu);


        router.navigate("/studentScreen");






    }
}
