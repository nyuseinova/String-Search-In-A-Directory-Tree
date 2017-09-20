package string.search.tests;

import string.search.AllTxtFiles;
import string.search.Constants;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.fail;

public class AllTextFilesTest {
    @Test
    public void testIfAllElementsInTheArrayListAreTxtFiles() {
        ArrayList<File> txtFiles = AllTxtFiles.findAllTxtFiles(Constants.dir);

        Iterator<File> iter = txtFiles.iterator();
        while (iter.hasNext()) {
            File nextFile = iter.next();

            if (!nextFile.toString().endsWith(".txt") | !nextFile.isFile()) {
                fail("There is elements in the ArrayList which is not text file.");
            } else {
                iter.remove();
            }
        }
    }
}
