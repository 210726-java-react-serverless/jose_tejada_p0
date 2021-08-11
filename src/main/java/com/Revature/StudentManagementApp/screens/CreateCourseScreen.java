package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Courses;
import com.Revature.StudentManagementApp.repositories.CourseRepository;
import com.Revature.StudentManagementApp.services.CourseService;
import com.Revature.StudentManagementApp.util.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;

public class CreateCourseScreen extends Screen{

    CourseService courseService;


    public CreateCourseScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService) {
        super("Create Course", "/createCourse", consoleReader, router);
        this.courseService = courseService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("\nEnter the information for the course you want to create");
        System.out.println("=======================================================\n");

        System.out.print("Course Name: ");
        String course_name = consoleReader.readLine();

        System.out.print("Course code: ");
        String course_code = consoleReader.readLine();

        System.out.print("Open for Registration(dd/mm/yyyy): " );
        String start_date = consoleReader.readLine();

        System.out.print("Last day to register and drop(dd/mm/yyyy): ");
        String end_date = consoleReader.readLine();

        try {
            Courses c = new Courses(course_name, course_code, start_date, end_date);
            courseService.addCourseToCatalog(c);
            logger.info("Successfully add course to catalog");
            router.navigate("/facultyScreen");

        }catch (Exception y){
            logger.error("Fields may have been left blank");
            System.out.println("Please try again");
        }



    }
}
