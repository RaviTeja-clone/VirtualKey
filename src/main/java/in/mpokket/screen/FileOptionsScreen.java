package in.mpokket.screen;

import in.mpokket.entity.Directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileOptionsScreen implements VisualInterface {
    private final Directory dir = new Directory();
    private final ArrayList<String> options = new ArrayList<>();

    public FileOptionsScreen() {
        options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
    }

    @Override
    public void show() {
        System.out.println("----------------------------------");
        System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void getUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.navigateOption(selectedOption);
        }
    }

    @Override
    public void navigateOption(int option) {

        switch (option) {
            case 1 -> { // Add File
                this.addFile();
                this.show();
            }
            case 2 -> { // Delete File
                this.deleteFile();
                this.show();
            }
            case 3 -> { // Search File
                this.searchFile();
                this.show();
            }
            default -> System.out.println("Invalid Option");
        }

    }

    public void addFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a file named: " + fileName);

        try {
            File file = new File(dir.getName() + fileName);

            if (file.createNewFile()) {
                System.out.println("Note: File got created: " + file.getName());
                dir.getFiles().add(file);
                return;
            }

            System.out.println("This File Already Exits, no need to add another");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteFile() {

        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);

        Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
        File file = path.toFile();
        if (file.delete()) {
            System.out.println("Deleted File: " + file.getName());
            dir.getFiles().remove(file);
        } else {
            System.out.println("Failed to delete file:" + fileName + ", file was not found.");
        }
    }

    public void searchFile() {

        boolean found = false;

        System.out.println("Please Enter the Filename: ");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);

        ArrayList<File> files = dir.getFiles();

        for (File file : files) {
            if (file.getName()
                    .equals(fileName)) {
                System.out.println("Found " + fileName);
                found = true;
            }
        }
        if (!found) {
            System.out.println("File not found");
        }
    }

    private String getInputString() {
        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }

    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid input");
        }
        return returnOption;
    }

}
