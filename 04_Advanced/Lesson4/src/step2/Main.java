/* Завдання 2. Напишіть жартівливу програму «Дешифратор», яка в текстовому файлі могла б замінити всі прийменники слово «Java».

   Додаткове завдання 2.1 по регулярним виразам:
        Є файл. В файлі купа тексту.
        Користувач вводить щось, що він хоче знати, чи є згадки про це слово у тексті.
        Програма заглядає у файл, робить пошук, та видає результат у вигляді кількості згадувань у тексті цього слова.
        Можливості пошуку закінчуються по стоп-слову.
 */
package step2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class FileEncrypter {
    private final String REPLACE_WORD = "Java";
    private String sourceFileName;
    private String fileName2;
    private String regexp;
    private Pattern pattern;

    /**
     * @param dictFileName   ім'я файлу-словнику с пошуковими словами
     * @param sourceFileName ім'я файлу, що оброблюється
     */
    public FileEncrypter(String dictFileName, String sourceFileName) {
        this.sourceFileName = sourceFileName;
        Path path = Paths.get(sourceFileName);

        // Перевірити наявність файлу, що оброблюється
        if (!Files.isReadable(path)) {
            System.err.println("Якась халепа із файлом " + sourceFileName + ". Нажаль, продовжувати немає сенсу.");
            throw new RuntimeException();
        }

        if (sourceFileName.lastIndexOf('.') == -1) this.fileName2 = sourceFileName + "_out.txt";
        else this.fileName2 = sourceFileName.substring(0, sourceFileName.lastIndexOf('.')) + "_out.txt";

        // Завантажити непохідні прийменники із файлу-словнику
        regexp = "";
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;

        try {
            fileReader = new FileReader(dictFileName);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                regexp = regexp.concat(regexp.isEmpty() ? "" : "|");
                regexp = regexp.concat(line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Помилка під час завантаження файлу словнику " + dictFileName);
            throw new RuntimeException(e);
        }

        // скомпілювати патерн
        regexp = "\\b(" + regexp + ")\\b";
        try {
            pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        } catch (PatternSyntaxException e) {
            throw new RuntimeException("Помилка компіляції рег.виразу: " + e.getMessage());
        }
    }

    /**
     * @param workMode  true - утворювати вихідний файл, false - не утворювати
     * @param stopWord  стоп-слово, після якого зупиняти обробку
     */
    public void encrypt(boolean workMode, String stopWord) {
        String clause;
        FileReader fileReader;
        FileWriter fileWriter;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter = null;

        Matcher matcher;
        int prepsFound = 0;

        try {
            fileReader = new FileReader(sourceFileName);
            bufferedReader = new BufferedReader(fileReader);
            if (workMode) {
                fileWriter = new FileWriter(fileName2);
                bufferedWriter = new BufferedWriter(fileWriter);
            }

            while ((clause = bufferedReader.readLine()) != null) {
                matcher = pattern.matcher(clause);

                // Програма заглядає у файл, робить пошук, та видає результат у вигляді кількості згадувань у тексті цього слова.
                while (matcher.find()) prepsFound++;

                clause = matcher.replaceAll(REPLACE_WORD);

                // Можливості пошуку закінчуються по стоп-слову.
                if (!stopWord.isEmpty() && clause.contains(stopWord)) {
                    String s = clause.substring(clause.indexOf(stopWord));
                    int lastIndex = 0;
                    // відняти знайдену кількість слів зі словнику в реченні після стоп-слова
                    while (lastIndex != -1) {
                        lastIndex = s.indexOf(REPLACE_WORD, lastIndex);
                        if (lastIndex != -1) {
                            prepsFound--;
                            lastIndex += REPLACE_WORD.length();
                        }
                    }
                    break;
                }

                if (workMode) bufferedWriter.write(clause + "\r\n");
            }

            bufferedReader.close();
            System.out.println("Знайдено " + prepsFound + " прийменників");
            if (workMode) {
                bufferedWriter.close();
                System.out.println("Оброблений файл: " + fileName2);
            }
        } catch (IOException e) {
            System.err.println("Помилка під час обробки файлів");
            throw new RuntimeException(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FileEncrypter e;

        e = new FileEncrypter("прийменники.txt", "step4.txt");
        e.encrypt(false, "");

        e = new FileEncrypter("прийменники.txt", "step4.txt");
        e.encrypt(false, "stop");

        e = new FileEncrypter("прийменники.txt", "step4.txt");
        e.encrypt(true, "stop");
    }
}