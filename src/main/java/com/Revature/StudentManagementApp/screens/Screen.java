package com.Revature.StudentManagementApp.screens;

import com.Revature.StudentManagementApp.util.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;

public  abstract class Screen {
    protected String name;
    protected String route;
    protected BufferedReader consoleReader;
    protected ScreenRouter router;
    protected final Logger logger = LogManager.getLogger(Screen.class);


    public Screen(String name, String route, BufferedReader consoleReader, ScreenRouter router) {
        this.name = name;
        this.route = route;
        this.consoleReader = consoleReader;
        this.router = router;
    }


    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render() throws Exception;

}

