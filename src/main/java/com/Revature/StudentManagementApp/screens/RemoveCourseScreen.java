package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.services.CourseService;
import com.Revature.StudentManagementApp.services.RegistrationService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class RemoveCourseScreen extends Screen{
    RegistrationService registrationService;
    CourseService courseService;



    public RemoveCourseScreen(BufferedReader consoleReader, ScreenRouter router, RegistrationService registrationService, CourseService courseService) {
        super("Remove Course", "/removeCourse", consoleReader, router);
        this.registrationService = registrationService;
        this.courseService = courseService;
    }

    @Override
    public void render() throws Exception {


        registrationService.listCoursesAvailable();
        System.out.println("--Select the course that you would like to delete--\n--type in the course code--" +
                ">");
        String course_code = consoleReader.readLine();

        System.out.println("Are you sure you want to delete the course (Y/N) \n>");
        String userSelection = consoleReader.readLine();

        switch (userSelection){
            case "y":

            case "Y":
                registrationService.removeStudentsRegisteredToCourse(course_code);
                courseService.deleteCourse(course_code);
                router.navigate("/facultyScreen");

                break;

            case "n":


            case "N":
                router.navigate("/facultyScreen");
                break;

        }







    }


}
