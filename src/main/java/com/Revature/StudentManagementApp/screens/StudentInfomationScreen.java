package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentInfomationScreen extends Screen{
    StudentService studentService;
    public StudentInfomationScreen(BufferedReader consoleReader, ScreenRouter router,  StudentService studentService) {
        super("StudentInformationScreen", "/sis", consoleReader, router);
        this.studentService = studentService;
    }



    @Override
    public void render() throws Exception {
        System.out.println("=======================================");
        System.out.println("*             YOUR INFORMATION         *");
        System.out.println("=======================================");

        Student stu = studentService.getSesh().getCurrentUserStudent();
        System.out.println("Name: "+ stu.getUser().getFirst_name() + " " + stu.getUser().getLast_name() + "\n" +
                "Major: "+ stu.getMajor()+ "\n" +
                "Date of Birth: "+ stu.getUser().getDOB() + "\n" +
                "Phone Number: "+ stu.getUser().getPhone_num() + "\n" +
                "Username: "+ stu.getUser().getUser_name() + "\n" +
                "Email: "+ stu.getUser().getEmail() + "\n" +
                "Address: "+ stu.getUser().getAddress().getNumber() + " " + stu.getUser().getAddress().getStreet() + " " + stu.getUser().getAddress().getStreet() + " " + stu.getUser().getAddress().getCity() + ", " + stu.getUser().getAddress().getState() + " " + stu.getUser().getAddress().getZip_code() +"\n" );

        router.navigate("/studentScreen");

    }
}
