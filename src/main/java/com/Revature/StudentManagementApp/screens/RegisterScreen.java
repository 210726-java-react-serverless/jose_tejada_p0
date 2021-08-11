package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Address;
import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.repositories.FacultyRepository;
import com.Revature.StudentManagementApp.repositories.StudentRepository;
import com.Revature.StudentManagementApp.services.FacultyService;
import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class RegisterScreen extends Screen{
    StudentService stu_service;
    FacultyService facultyService;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, StudentService studentService, FacultyService fr) {
            super("Register Screen", "/register", consoleReader, router);
            this.stu_service = studentService;
            this.facultyService = fr;

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

            System.out.print("Date of birth (dd/mm/yyyy): " );
            String dob = consoleReader.readLine();

            System.out.print("Phone number: ");
            String phoneNumber = consoleReader.readLine();

            System.out.print("Email: ");
            String email = consoleReader.readLine();

            System.out.print("Username: ");
            String username = consoleReader.readLine();

            System.out.print("Password: ");
            String password = consoleReader.readLine();


            System.out.println("\nEnter your address details:");
            System.out.print("Street Number: ");
            String streetNumber = consoleReader.readLine();

            System.out.print("Street:");
            String street = consoleReader.readLine();

            System.out.print("City: ");
            String city = consoleReader.readLine();

            System.out.print("State: ");
            String state = consoleReader.readLine();

            System.out.print("county: ");
            String country = consoleReader.readLine();

            System.out.print("Zip Code: ");
            String zipCode = consoleReader.readLine();
            Address a = new Address(streetNumber, street, city, state, country, zipCode);

            try {
                switch (userSelection) {

                    case "1":
                        try {

                            System.out.print("Declared Major: ");
                            String major = consoleReader.readLine();

                            Student stu = new Student(major,firstName, lastName, dob, phoneNumber, username, password, email, a);

                            stu_service.register(stu);
                            router.navigate("/welcome");

                        } catch (Exception e) {

                            System.out.println(e.getMessage());
                            router.navigate("/welcome");

                        }
                        break;

                    case "2":

                        try {

                            System.out.print("Department Reistering for: ");
                            String department = consoleReader.readLine();



                            Faculty faculty = new Faculty(0, department, firstName, lastName, dob,phoneNumber, username, password,email, a);
                            System.out.println(faculty);


                            facultyService.register(faculty);
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

