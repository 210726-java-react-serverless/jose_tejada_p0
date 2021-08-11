package com.Revature.StudentmanagementApp.services;

import com.Revature.StudentManagementApp.exceptions.InvalidRequestException;
import com.Revature.StudentManagementApp.models.Courses;
import com.Revature.StudentManagementApp.repositories.CourseRepository;
import com.Revature.StudentManagementApp.services.CourseService;
import com.Revature.StudentManagementApp.services.RegistrationService;
import org.junit.*;
import org.mockito.Mockito;

public class CourseServiceTestSuite {

    private static RegistrationService mokCourseService;
    private static CourseService sut;

    private static CourseRepository mokCourseReop;



//TODO test %80 of my logic

//    @BeforeClass  public void setUpSuite(){};
//
//
//    @AfterClass


    @Before
    public void beforeEachTest(){
        mokCourseReop = Mockito.mock(CourseRepository.class);
        mokCourseService = Mockito.mock(RegistrationService.class);
        sut = new CourseService(mokCourseReop, mokCourseService);

    }

    @After
    public void afterEachTest(){
        sut = null;
    }



    @Test(expected = InvalidRequestException.class)
    public void Expect_failed_test()
    {

        Courses c1 = new Courses(null, null, null, null);
        Courses c2 = new Courses(null, " ", " ", " ");
        Courses c3 = new Courses(" ", null, " ", " ");
        Courses c4 = new Courses(" ", " ", null, " ");

        try{
            sut.addCourseToCatalog(c1);
            sut.addCourseToCatalog(c2);
            sut.addCourseToCatalog(c3);
            sut.addCourseToCatalog(c4);
        }finally {

            Mockito.verify(mokCourseReop, Mockito.times(0)).save(Mockito.any());
        }


    }

    @Test
    public void expectedToPass()
    {
        Courses c = new Courses("jose", "jose", "jose", "jose");

        try{
            sut.addCourseToCatalog(c);
        }finally {

            Mockito.verify(mokCourseReop, Mockito.times(1)).save(Mockito.any());
        }
    }


}
