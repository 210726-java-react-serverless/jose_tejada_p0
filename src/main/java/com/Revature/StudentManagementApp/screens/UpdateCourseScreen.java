package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.models.Courses;
import com.Revature.StudentManagementApp.services.CourseService;
import com.Revature.StudentManagementApp.services.RegistrationService;
import com.Revature.StudentManagementApp.util.ScreenRouter;

import java.io.BufferedReader;

public class UpdateCourseScreen extends Screen{

    CourseService courseService;
    RegistrationService registrationService;


    public UpdateCourseScreen(BufferedReader consoleReader, ScreenRouter router, CourseService courseService, RegistrationService registrationService) {
        super("Update Course", "/updateCourse", consoleReader, router);
        this.courseService = courseService;
        this.registrationService = registrationService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("\n");
        registrationService.listCoursesOffered();
        System.out.println("\n *** Select what course you want to update ***\n-Enter course code");

        String courseToUpdate = consoleReader.readLine();
        Courses C = registrationService.findByCourseCode(courseToUpdate);
        System.out.println("--------------------");
        System.out.println("The course details");
        System.out.println("--------------------");
        if( C == null)
        {
            logger.error("That course does not exist");
            logger.info("Wrong code code may have been entered");
            router.navigate("/facultyScreen");
        }


        assert C != null;
        System.out.printf("Course Name: %s\nCourse Code: %s\nStart Date: %s\nEnd Date: %s\n", C.getCourse_name(), C.getCourse_code(), C.getStart_date(), C.getEnd_date());
        System.out.println("\nWhat detail do you want to update");
        String menu = "*****************************\n" +
                "-1) Course Name\n" +
                "-2) Course Code\n" +
                "-3) Start registration date\n" +
                "-4) Last day to register and drop \n" +
                "> ";

        System.out.println(menu);
        String fieldToUpdate = consoleReader.readLine();

        switch (fieldToUpdate){

            case "1":
                System.out.println("Updated course name to: ");
                String updatedname = consoleReader.readLine();
                courseService.updateCourse(C,"course_name", updatedname);
                logger.info("Successfully updated this course:  " + C.getCourse_code());
                router.navigate("/facultyScreen");
                break;

            case "2":
                System.out.println("Updated course code to: ");
                String updatedcode = consoleReader.readLine();
                courseService.updateCourse(C,"course_code", updatedcode);
                logger.info("Successfully updated this course:  " + C.getCourse_code());
                router.navigate("/facultyScreen");
                break;

            case "3":
                System.out.println("Updated start date to: ");
                String updatedstartdate = consoleReader.readLine();
                courseService.updateCourse(C,"start_date", updatedstartdate);
                logger.info("Successfully updated this course:  " + C.getCourse_code());
                router.navigate("/facultyScreen");
                break;

            case "4":
                System.out.println("Updated end date to: ");
                String updatedendDate = consoleReader.readLine();
                courseService.updateCourse(C,"end_date", updatedendDate);
                logger.info("Successfully updated this course:  " + C.getCourse_code());
                router.navigate("/facultyScreen");
                break;
            default:
                logger.error("That field option doesnt exits");
                router.navigate("/facultyScreen");
                break;

        }





    }
}
