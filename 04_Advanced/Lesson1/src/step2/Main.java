// Завдання 2. Виведення на екран елементів List: Створити список, заповнити його на 10 елементів та вивести на екран вміст, використовуючи iterator.
package step2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Person implements Comparable<Person> {
    private final String surname, name;
    private final LocalDate birthDate;

    public Person(String surname, String name, LocalDate birthDate) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        DateTimeFormatter aFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("%-15s %-15s %-10s ", name, surname, birthDate.format(aFormatter));
    }

    public int compareByDate(Person o) {
        return this.birthDate.compareTo(o.birthDate);
    }

    public int compareBySurname(Person o) {
        return this.surname.compareTo(o.surname);
    }

    @Override
    public int compareTo(Person o) {
        return compareByDate(o);
    }
}

public class Main {
    static void printList(List<Person> list, String comment) {
        System.out.println("     Ім'я           Прізвище      Д.н.    (" + comment + ")");
        System.out.println("--------------- --------------- ----------");

        // ..вивести на екран вміст, використовуючи iterator
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("person.csv"))) {
            while (scanner.hasNextLine()) {
                try (Scanner rowScanner = new Scanner(scanner.nextLine())) {
                    rowScanner.useDelimiter(",");

                    list.add(new Person(rowScanner.next(), rowScanner.next(), LocalDate.of(Integer.parseInt(rowScanner.next()), Integer.parseInt(rowScanner.next()), Integer.parseInt(rowScanner.next()))));
                }
            }

            // Вариант №1. compareTo
            Collections.sort(list);
            printList(list, "за днем нар.");

            // Вариант №2.
            list.sort(Person::compareBySurname);
            printList(list, "за прізвищем");

            // Вариант №3. List + Comparator
            list.sort(new Comparator<>() {
                public int compare(Person o1, Person o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            printList(list, "за ім'ям");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
