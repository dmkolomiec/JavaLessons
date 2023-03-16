/* Завдання 4. Створіть у пакеті текстовий файл і клас, внесіть у файл якийсь текст. Виведіть на екран вміст файлу.
 */
package step4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Створіть у пакеті ... клас
class FileReadWriteTester {
    final Path path;

    public FileReadWriteTester(String path) {
        this.path = Paths.get(path);
    }

    public void Save() {
        String saveText = LocalTime.now().format(DateTimeFormatter.ISO_TIME) + ". " + "Завдання 4. Створіть у пакеті текстовий файл і клас, внесіть у файл якийсь текст. Виведіть на екран вміст файлу." + "\n";

        try {
            // Створіть у пакеті текстовий файл...
            if (!Files.exists(path)) Files.createFile(path);

            // ...внесіть у файл якийсь текст
            Files.write(path, saveText.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAndView() {
        String loadText;
        try {
            // ..внесіть у файл якийсь текст.
            loadText = new String(Files.readAllBytes(path));

            // Виведіть на екран вміст файлу.
            System.out.println(loadText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FileReadWriteTester tester = new FileReadWriteTester("step4.txt");
        tester.Save();
        tester.loadAndView();
    }
}
