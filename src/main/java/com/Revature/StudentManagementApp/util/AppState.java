package com.Revature.StudentManagementApp.util;

import com.Revature.StudentManagementApp.repositories.CourseRepository;
import com.Revature.StudentManagementApp.repositories.FacultyRepository;
import com.Revature.StudentManagementApp.repositories.RegistrationRepository;
import com.Revature.StudentManagementApp.repositories.StudentRepository;
import com.Revature.StudentManagementApp.screens.*;
import com.Revature.StudentManagementApp.services.CourseService;
import com.Revature.StudentManagementApp.services.FacultyService;
import com.Revature.StudentManagementApp.services.RegistrationService;
import com.Revature.StudentManagementApp.services.StudentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    static private boolean appRunning;
    private final ScreenRouter router;


    //conctructor
    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));


        CurrentUser studentSesh = new CurrentUser();
        StudentRepository userRepo = new StudentRepository();
        StudentService studentService = new StudentService(userRepo, studentSesh);

        CurrentUser facultySesh = new CurrentUser();
        FacultyRepository facRepo = new FacultyRepository();
        FacultyService facultyService = new FacultyService(facRepo, facultySesh);

        RegistrationRepository registrationRepository = new RegistrationRepository();
        RegistrationService registrationService = new RegistrationService(registrationRepository, studentSesh);

        CourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService(courseRepository, registrationService);





        router.addScreen(new WelcomeScreen(consoleReader, router, registrationService))
                .addScreen(new LoginScreen(consoleReader, router, studentService, facultyService))
                .addScreen(new RegisterScreen(consoleReader, router, studentService, facultyService))
                .addScreen(new StudentScreen(consoleReader, router, studentService))
                .addScreen(new FacultyScreen(consoleReader, router, facultyService))
                .addScreen(new AddClassesScreen(consoleReader, router, registrationService))
                .addScreen(new StudentInfomationScreen(consoleReader, router, studentService))
                .addScreen(new DropClassScreen(consoleReader, router, registrationService, studentService))
                .addScreen(new RegisteredCoursesScreen(consoleReader, router, registrationService, studentService))
                .addScreen(new FacultyInformationScreen(consoleReader, router, facultyService))
                .addScreen(new CreateCourseScreen(consoleReader, router, courseService))
                .addScreen(new RemoveCourseScreen(consoleReader, router,registrationService, courseService))
                .addScreen(new UpdateCourseScreen(consoleReader, router, courseService, registrationService));

    }

    static public void stoprunning(){
        appRunning = false;
    }

    public void startup() {
        router.navigate("/welcome");

        while (appRunning) {
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
