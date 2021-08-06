package com.Revature.StudentManagementApp.util;

import com.Revature.StudentManagementApp.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Screen currentScreen;
    private Set<Screen> screens = new HashSet<>();

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

    public Screen getCurrentScreen() {
        return currentScreen;
    }

}
