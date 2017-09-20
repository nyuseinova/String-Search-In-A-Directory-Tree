package string.search;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Constants {
    public static final String START_DIRECTORY = "/Users/nezife/Documents";
    public static final String STRING_TO_SEARCH = "text";
    public static int CONSUMERS = 11;
    public static Path dir = FileSystems.getDefault().getPath(START_DIRECTORY);
}