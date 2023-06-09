package in.mpokket;

import in.mpokket.screen.WelcomeScreen;

public class VirtualKeyApplication {
    public static void main(String[] args) {
        WelcomeScreen welcome = new WelcomeScreen();
        welcome.welcomeScreenWithIntro();
        welcome.getUserInput();
    }
}