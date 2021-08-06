package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.util.AppState;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class WelcomeScreen extends Screen{
    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("Welcome Screen", "/welcome", consoleReader, router);
    }




    @Override
    public void render() throws Exception {


        String menu = "\nWelcome to the University of Revature\n" +
                "1) Login\n" +
                "2) Register\n" +
                "3) View Courses offered\n"+
                "4) Exit application\n"+
                "> ";
        System.out.println(menu);
        String userSelection = consoleReader.readLine();
        try {

            switch(userSelection){
                case "1":
                    router.navigate("/login");
                    break;
                case "2":
                    router.navigate("/register");
                    break;
                case "3":
//                     System.out.println("courses offered");
////                    router.navigate("/delete");
                    break;
                case "4":
                    System.out.println("Exiting Application.....");
                    AppState.stoprunning();
                    break;
                default:
                    System.out.println(" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not a valid Entry");
        }


    }



    }

