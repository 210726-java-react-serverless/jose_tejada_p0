package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.services.FacultyService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class FacultyInformationScreen extends Screen{
    private final FacultyService facultyService;

    public FacultyInformationScreen(BufferedReader consoleReader, ScreenRouter router, FacultyService facultyService) {
        super("Faculty Information", "/fis", consoleReader, router);
        this.facultyService = facultyService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("=======================================");
        System.out.println("*             YOUR INFORMATION         *");
        System.out.println("=======================================");
        Faculty faculty= facultyService.getSesh().getCurrentUserFaculty();
        System.out.println("Name: "+ faculty.getUser().getFirst_name() + " " + faculty.getUser().getLast_name() + "\n" +
                "Department: "+ faculty.getDepartment()+ "\n" +
                "Date of Birth: "+ faculty.getUser().getDOB()+ "\n" +
                "Phone Number: "+ faculty.getUser().getPhone_num() + "\n" +
                "Username: "+ faculty.getUser().getUser_name() + "\n" +
                "Email: "+ faculty.getUser().getEmail() + "\n" +
                "Address: "+ faculty.getUser().getAddress().getNumber() + " " + faculty.getUser().getAddress().getStreet() + " " + faculty.getUser().getAddress().getStreet() + " " + faculty.getUser().getAddress().getCity() + ", " + faculty.getUser().getAddress().getState() + " " + faculty.getUser().getAddress().getZip_code() +"\n" );

        router.navigate("/facultyScreen");

    }


}
