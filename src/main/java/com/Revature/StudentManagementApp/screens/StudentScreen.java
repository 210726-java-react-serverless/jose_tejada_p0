package com.Revature.StudentManagementApp.screens;


import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentScreen extends Screen{

    private final StudentService studentService;

    public StudentScreen(BufferedReader consoleReader, ScreenRouter router, StudentService studentService) {
        super("Student Screen", "/studentScreen", consoleReader, router);
        this.studentService = studentService;
    }

    @Override
    public void render() throws Exception {
        Student stu = studentService.getSesh().getCurrentUserStudent();
        System.out.println("\n*****************************");
        System.out.println("Hello " + stu.getUser().getFirst_name());
        String menu = "\nWelcome to the Student screen\n" +
                        "*****************************\n" +
                "-1) View my information\n" +
                "-2) Register for classes\n" +
                "-3) Drop classes\n" +
                "-4) View my classes\n" +
                "-5) Logout\n" +
                "-> ";

        System.out.println(menu);
        String userSelection = consoleReader.readLine();

        switch (userSelection){
            case "1":

                router.navigate("/sis");
                break;

            case "2":

                router.navigate("/addcourses");
                break;

            case "3":

                System.out.println("--Here are the courses you are registered to--");
                router.navigate("/dropScreen");
                break;


            case "4":

                router.navigate("/registeredClasses");
                break;

            case "5":

                System.out.println("GOODBYE!");
                studentService.getSesh().endSessionStudent();
                router.navigate("/welcome");
                break;
            default:
                logger.error("Not a valid Menu option");


        }


    }
}
