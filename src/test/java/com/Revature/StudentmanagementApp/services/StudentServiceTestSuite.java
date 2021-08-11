package com.Revature.StudentmanagementApp.services;
import com.Revature.StudentManagementApp.exceptions.InvalidRequestException;
import com.Revature.StudentManagementApp.models.Address;
import com.Revature.StudentManagementApp.models.Courses;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.repositories.StudentRepository;
import com.Revature.StudentManagementApp.services.StudentService;
import com.Revature.StudentManagementApp.util.CurrentUser;
import org.junit.*;
import org.mockito.Mockito;


public class StudentServiceTestSuite {

    private static StudentRepository mokStudentrepo;
    private static StudentService sut;
    private static CurrentUser sesh;






    @Before
    public void beforeEachTest() {
         mokStudentrepo = Mockito.mock(StudentRepository.class);
         sesh = Mockito.mock(CurrentUser.class);
         sut = new StudentService(mokStudentrepo, sesh);
    }
    @After
    public void afterEachTest(){
        sut = null;
    }

    @Test(expected = InvalidRequestException.class)
    public void Expect_failed_test()
    {
        Address a1 = new Address(" ", " ", " ", " ", " ", " ");
        Address a2 = new Address(" ", " ", " ", " ", " ", " ");
        Address a3 = new Address(" ", " ", " ", " ", " ", " ");
        Address a4 = new Address(" ", " ", " ", " ", " ", " ");
        Student c1 = new Student(null, null, null, null,"hj ", " jh"," jh"," jh", a1);
        Student c2 = new Student(null, " ", " ", " ", " ", " ", " ", " ", a2);
        Student c3 = new Student(" ", " ", null, " ", " ", " "," ", "",a3);
        Student c4 = new Student(" ", " ", null, " ", " ", " "," ", "",a4);

        try{
            sut.register(c1);
            sut.register(c2);
            sut.register(c3);
            sut.register(c4);
        }finally {

            Mockito.verify(mokStudentrepo, Mockito.times(0)).save(Mockito.any());
        }


    }

    @Test
    public void expectedToPass()
    {
        Address a = new Address(" ", " ", " ", " ", " ", " ");
        Student c = new Student("jose", "jose", "jose", "jose", "jose", "jose", "jose", "jose", a);

        try{
            sut.register(c);
        }finally {

            Mockito.verify(mokStudentrepo, Mockito.times(1)).save(Mockito.any());
        }
    }





}
