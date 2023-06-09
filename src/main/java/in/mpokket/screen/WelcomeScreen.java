package in.mpokket.screen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import in.mpokket.service.DirectoryService;
import in.mpokket.service.ScreenService;

public class WelcomeScreen implements VisualInterface {
    private final String WELCOME_TEXT = "Welcome to Virtual Key For the Repositories!";
    private final String DEVELOPER = "Developer: Vangala Ravi Teja";

    private final ArrayList<String> options = new ArrayList<>();

    public WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }

    public void welcomeScreenWithIntro() {
        System.out.println(WELCOME_TEXT);
        System.out.println(DEVELOPER);
        System.out.println("\n");
        show();
    }



    @Override
    public void show() {
        System.out.println("----------------------------------");
        System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }
        System.out.println("Kindly input the option: ");
    }

    public void getUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.navigateOption(selectedOption);
        }
    }

    @Override
    public void navigateOption(int option) {
        switch (option) {
            case 1 -> { // Show Files in Directory
                this.showFiles();
                this.show();
            }
            case 2 -> { // Show File Options menu
                ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen()
                             .show();
                ScreenService.getCurrentScreen()
                             .getUserInput();
                this.show();
            }
            default -> System.out.println("Invalid Option");
        }

    }

    public void showFiles() {
        System.out.println("----------------------------------");
        System.out.println("List of Files: ");
        DirectoryService.printFiles();

    }

    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ignored) {

        }
        return returnOption;

    }
}
