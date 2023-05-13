package task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class XMLParser {
    public static void run(String filePath, String tagName) {
        Path path = Paths.get(filePath);
        String xmlText;

        String regexp = "<" + tagName + "\\h(.+)>";
//        String regexp = "<model\\h(.+?)</model>"; // !!!

        try {
            xmlText = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] a = xmlText.split(regexp);
        for (int i = 1; i < a.length; i++) {
            if(i == a.length - 1 )
                System.out.println(a[i].substring(1, a[i].indexOf("</" + tagName + ">")));
            else
                System.out.println(a[i].trim());
        }
        System.out.println("Всего шлака: " + (a.length - 1));
    }
}
