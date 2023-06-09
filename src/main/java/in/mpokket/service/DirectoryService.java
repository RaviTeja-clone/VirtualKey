package in.mpokket.service;


import in.mpokket.entity.Directory;

import java.io.File;

public class DirectoryService {

    private static final Directory fileDirectory = new Directory();

    public static void printFiles() {

        fileDirectory.fillFiles();

        for (File file : DirectoryService.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }


}
