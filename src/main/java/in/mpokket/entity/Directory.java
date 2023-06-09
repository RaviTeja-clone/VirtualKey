package in.mpokket.entity;


import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Directory {
    public static final String name = "src/main/resources/files/";
    private final ArrayList<File> files = new ArrayList<>();
    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
    File directoryOfFiles = path.toFile();
    public String getName() {
        return name;
    }

    public void fillFiles() {
        File[] directoryFiles = directoryOfFiles.listFiles();

        files.clear();
        for (int i = 0; i < Objects.requireNonNull(directoryFiles).length; i++) {
            if (directoryFiles[i].isFile()) {
                files.add(directoryFiles[i]);
            }
        }

        Collections.sort(files);
    }

    public ArrayList<File> getFiles() {
        fillFiles();
        return files;
    }
}
