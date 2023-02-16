package org.example.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class FileUtils {

    public static String getHtmlPageByPath(String path) throws FileNotFoundException {
        if (path.equals("/")) {
            return getHtmlPageByName("/index.html");
        } else {
            return getHtmlPageByName(path);
        }
    }

    public static String getHtmlPageByName(String fileName) throws FileNotFoundException {

        File file = new File("src/main/resources/web" + fileName);

        Scanner scanner = new Scanner(file);
        StringJoiner stringJoiner = new StringJoiner("\n");
        while (scanner.hasNext()) {
            stringJoiner.add(scanner.nextLine());

        }
        return stringJoiner.toString();
    }
}
