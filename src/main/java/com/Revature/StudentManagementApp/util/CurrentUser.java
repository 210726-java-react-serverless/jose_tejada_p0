package com.Revature.StudentManagementApp.util;

import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.models.Student;

public class CurrentUser {
    private Student currentUserStudent;
    private Faculty currentUserFaculty;

    public Student getCurrentUserStudent() {
        return currentUserStudent;
    }

    public Faculty getCurrentUserFaculty(){
        return currentUserFaculty;
    }

    public void setCurrentUserStudent(Student currentUser) {
        this.currentUserStudent = currentUser;
    }

    public void setCurrentUserFaculty(Faculty currentUser) {

        this.currentUserFaculty = currentUser;
    }

    public boolean isActiveStudent() {
        return currentUserStudent != null;
    }

    public boolean isActiveFaculty() {
        return currentUserFaculty != null;
    }

    public void endSessionStudent() {
        setCurrentUserStudent(null);
    }

    public void endSessionFaculty() {
        setCurrentUserFaculty(null);
    }



}
