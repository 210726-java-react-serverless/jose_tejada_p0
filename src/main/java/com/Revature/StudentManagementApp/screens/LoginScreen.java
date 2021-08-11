package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.services.FacultyService;
import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import java.io.BufferedReader;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class LoginScreen extends Screen{
    private final Logger logger = LogManager.getLogger(LoginScreen.class);
    private  StudentService stu_service = null;
    private  FacultyService faculty_service = null;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, StudentService stu_service, FacultyService facultyService) {

        super("Login", "/login", consoleReader, router);
        this.stu_service = stu_service;
        this.faculty_service = facultyService;
    }






    @Override
    public void render() throws Exception {

        //User will decide what account to register for
        String menu = "\nWelcome to the University of Revature\n" +
                "1) Login as Student\n" +
                "2) Login as Faculty\n" +
                "> ";

        System.out.println(menu);
        String userSelection = consoleReader.readLine();





        System.out.println("Enter Username: \n" + ">\n");
        String username = consoleReader.readLine();

        System.out.println("Enter Password: \n" + ">\n");
        String password = consoleReader.readLine();


        ///If the user selects other then 1 or 2 it will allow the user to enter the email and password
        ///But will give them a message that they have to selected a valid account to register for
            switch (userSelection) {

                case "1":

                    try {
                        stu_service.login(username, password);
                        logger.info("Successfull Login");
                        router.navigate("/studentScreen");

                    }catch (Exception o){
                        logger.error(o.getMessage());
                        logger.debug("User Cannot login! Incorrect username or password");
                        router.navigate("/welcome");

                }

                    break;


                case "2":

                    try {
                        faculty_service.login(username, password);
                        logger.info("Successfull Login");
                        router.navigate("/facultyScreen");
                    }catch (Exception o)
                    {
                        logger.error(o.getMessage());
                        logger.debug("User Cannot login! Incorrect username or password");
                        router.navigate("/welcome");
                    }

                    break;


                default:
                    logger.error(" User Did not select and account for logging in");
                    System.out.println("We only have a student and faculty account");
                    router.navigate("/welcome");
                    break;

            }


    }
}
