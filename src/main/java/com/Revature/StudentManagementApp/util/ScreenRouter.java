package com.Revature.StudentManagementApp.util;

import com.Revature.StudentManagementApp.screens.Screen;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Screen currentScreen;
    private Set<Screen> screens = new HashSet<>();
    private final ArrayDeque<Screen> previousScreens;


    public ScreenRouter() {
        previousScreens = new ArrayDeque<Screen>();
    }

    public ScreenRouter addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    public void navigate(String route) {
        for (Screen screen : screens) {
            if (screen.getRoute().equals(route)) {
                currentScreen = screen;
                break;
            }
        }
    }

    public void goBack() {
        if(previousScreens.size() == 0){
            System.out.println("No screen");
        }
        currentScreen = previousScreens.pop();
    }



    public Screen getCurrentScreen() {

        return currentScreen;
    }

}
