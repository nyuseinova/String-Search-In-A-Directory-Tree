package string.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class AllTxtFiles {
    public static ArrayList findAllTxtFiles(Path dir) {
        //linked list
        ArrayList<File> txtFiles = new ArrayList<>();

        try {
            Files.walk(dir)
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> path.toString().endsWith(".txt"))
                    .forEach(path -> txtFiles.add(path.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return txtFiles;
        }
    }
}
