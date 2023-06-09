package in.mpokket.service;

import in.mpokket.screen.VisualInterface;
import in.mpokket.screen.WelcomeScreen;
import in.mpokket.screen.FileOptionsScreen;

public class ScreenService {
    public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static FileOptionsScreen FileOptionsScreen = new FileOptionsScreen();



    public static VisualInterface CurrentScreen = WelcomeScreen;


    public static VisualInterface getCurrentScreen() {
        return CurrentScreen;
    }


    public static void setCurrentScreen(VisualInterface currentScreen) {
        CurrentScreen = currentScreen;
    }



}
