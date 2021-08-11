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

        System.out.println("\n-Courses-");
        System.out.println("==============================");
        Student stu = registrationService.getSesh().getCurrentUserStudent();
        List<Courses> y = registrationService.listCoursesAvailable();

        System.out.println("\n=============================");
        System.out.println("\n-Enter the course code of the class you would like to register for-\n");







        String userSelection = consoleReader.readLine();
        try {

            registrationService.registerForClass(userSelection, stu);
            logger.info("Successfully Registered for class");
            router.navigate("/studentScreen");
        }catch(Exception d){
            logger.error("\nThat class is not available or does not exit");
            router.navigate("/studentScreen");
        }














    }


}
