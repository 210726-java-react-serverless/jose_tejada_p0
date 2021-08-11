package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.services.FacultyService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class FacultyScreen extends Screen{


    FacultyService facultyService;


    public FacultyScreen(BufferedReader consoleReader, ScreenRouter router, FacultyService facultyService) {
        super("Faculty Screen", "/facultyScreen", consoleReader, router);
        this.facultyService = facultyService;
    }



    @Override
    public void render() throws Exception {
        Faculty faculty = facultyService.getSesh().getCurrentUserFaculty();
        System.out.println("\n*****************************");
        System.out.println("Hello , Professor " +faculty.getUser().getLast_name());

        String menu = "\nWelcome to the Faculty screen\n" +
                        "*****************************\n" +
                "-1) See my Information \n" +
                "-2) Add course to registration Catalog\n" +
                "-3) Delete course from registration Catalog\n" +
                "-4) Update a Course\n" +
                "-5) Logout\n" +
                "-> ";

        System.out.println(menu);
        String userSelection = consoleReader.readLine();
        router.navigate("/facultyScreen");

        switch (userSelection){
            case "1":

                router.navigate("/fis");
                break;

            case "2":

                router.navigate("/createCourse");
                break;

            case "3":


                router.navigate("/removeCourse");
                break;


            case "4":

                router.navigate("/updateCourse");
                break;

            case "5":

                System.out.println("GOODBYE!");
                facultyService.getSesh().endSessionFaculty();
                router.navigate("/welcome");
                break;

        }




    }
}
