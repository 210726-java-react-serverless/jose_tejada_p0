package com.Revature.StudentManagementApp;

import com.Revature.StudentManagementApp.util.AppState;

public class App {
    static AppState app;
    public static void main(String[] args) {
        app = new AppState();
        app.startup();
    }
}
