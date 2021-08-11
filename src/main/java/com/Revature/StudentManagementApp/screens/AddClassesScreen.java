package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Courses;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.services.RegistrationService;
import com.Revature.StudentManagementApp.util.CurrentUser;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;
import java.util.Currency;
import java.util.List;

public class AddClassesScreen extends Screen{

    RegistrationService registrationService;

    public AddClassesScreen(BufferedReader consoleReader, ScreenRouter router, RegistrationService registrationService) {
        super("Add courses", "/addcourses", consoleReader, router);
        this.registrationService = registrationService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("\n=============================");
        System.out.println("\nEnter the course name\n");
        System.out.println("\n-Courses-");
        System.out.println("==============================");

        Student stu = registrationService.getSesh().getCurrentUserStudent();
        try {
            List<Courses> y = registrationService.listCoursesAvailable();

        }catch(Exception d){
            d.printStackTrace();
        }




        String userSelection = consoleReader.readLine();
        registrationService.registerForClass(userSelection, stu);
        router.navigate("/studentScreen");








    }


}
