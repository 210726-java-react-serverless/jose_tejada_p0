package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.repositories.FacultyRepository;
import com.Revature.StudentManagementApp.repositories.StudentRepository;
import com.Revature.StudentManagementApp.services.FacultyService;
import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class RegisterScreen extends Screen{
    StudentService stu_service = new StudentService();

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, StudentService studentService) {
            super("Register Screen", "/register", consoleReader, router);
            this.stu_service = studentService;

        }


        @Override
        public void render() throws Exception {

            System.out.println("\nRegister for a new account!");

            String menu = "\nWhat account are you registering for?\n" +
                    "1) Student Account\n" +
                    "2) Faculty Sccount\n" +
                    "> ";
            System.out.println(menu);
            String userSelection = consoleReader.readLine();


            System.out.print("First name: ");
            String firstName = consoleReader.readLine();

            System.out.print("Last name: ");
            String lastName = consoleReader.readLine();

            System.out.print("Email: ");
            String email = consoleReader.readLine();

            System.out.print("Username: ");
            String username = consoleReader.readLine();

            System.out.print("Password: ");
            String password = consoleReader.readLine();


            try {
                switch (userSelection) {
                    case "1":
                        try {
                            System.out.println("look it");
                            Student stu = new Student(firstName, lastName, email, username, password);
                            stu_service.register(stu);
                            System.out.println("Register screen");
                            router.navigate("/welcome");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            router.navigate("/welcome");
                        }
                        break;

                    case "2":
                        try {
                            Faculty faculty = new Faculty(firstName, lastName, email, username, password);
                            System.out.println(faculty);
                            FacultyRepository f = new FacultyRepository("src/main/resources/data.txt");
                            FacultyService faculty_service = new FacultyService(f);
                            faculty_service.register(faculty);

                            router.navigate("/welcome");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            router.navigate("/welcome");
                        }
                        router.navigate("/welcome");
                         break;
                        default:
                            System.out.println("You provided an invalid value, please try again.");
                        break;

                }
            }catch (Exception e){
                System.out.println("Not a valid entry");

            }

        }

    }

