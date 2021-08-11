package com.Revature.StudentManagementApp.services;

import com.Revature.StudentManagementApp.exceptions.InvalidRequestException;
import com.Revature.StudentManagementApp.models.Courses;
import com.Revature.StudentManagementApp.repositories.CourseRepository;

public class CourseService {

    private CourseRepository courseRepository;
    private RegistrationService registrationService;


    public CourseService(CourseRepository courseRepository, RegistrationService registrationService){
        this.courseRepository = courseRepository;
        this.registrationService = registrationService;

    }


    public Courses addCourseToCatalog(Courses newCourse){
        if (!isUserValid(newCourse)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }
        return courseRepository.save(newCourse);
    }



    private boolean isUserValid(Courses newCourse){
        if (newCourse == null) return false;
        if (newCourse.getCourse_code() == null || newCourse.getCourse_code().trim().equals("")) return false;
        if (newCourse.getCourse_name() == null || newCourse.getCourse_name().trim().equals("")) return false;
        if (newCourse.getStart_date() == null || newCourse.getStart_date().trim().equals("")) return false;
        if (newCourse.getEnd_date() == null || newCourse.getEnd_date().trim().equals("")) return false;
        return true;


    }


    public void deleteCourse(String code){
        courseRepository.deleteByCourseCode(code);
    }


    public Courses updateCourse(Courses c, String field, String changeTo){

        courseRepository.updateCourse(c, field, changeTo);


        return registrationService.findByCourseCode(c.getCourse_code());

    }




}
