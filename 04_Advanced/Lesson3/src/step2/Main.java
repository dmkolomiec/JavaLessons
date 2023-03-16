/* Завдання 2. Створіть файл, запишіть у нього довільні дані та закрийте файл. Потім знову відкрийте цей файл, прочитайте дані і виведіть їх на консоль.
 */
package step2;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

// Процедура 'InspectCode' сама замінила class на record
record Person(int id, String surname, String name, LocalDate birthDate) implements Serializable {

    @Override
    public String toString() {
        DateTimeFormatter aFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Person{ " + "id=" + id + ", Ім'я=" + name + ' ' + surname + ", д.н.=" + birthDate.format(aFormatter) + " }";
    }
}

public class Main {
    public static void main(String[] args) {
        final String filename = "step2.bin";
        byte[] ba = {1, 2, 3, 4, 5};
        byte[] ba2 = new byte[ba.length];

        ObjectOutputStream os;
        ObjectInputStream is;
        try {
            // Створіть файл, запишіть у нього довільні дані та закрийте файл.
            os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeBoolean(true);
            os.writeByte(127);
            os.writeShort(32767);
            os.writeLong(2_000_000_000);
            os.writeDouble(Math.PI);
            os.write(ba);
            os.writeUTF("Завдання 2. Створіть файл, запишіть у нього довільні дані та закрийте файл. Потім знову відкрийте цей файл, прочитайте дані і виведіть їх на консоль.");
            os.writeObject(new Person(1, "Сунак", "Ріші", LocalDate.of(1980, 5, 18)));

            os.close();

            // відкрийте цей грьобаний файл, прочитайте дані і виведіть їх на консоль.
            is = new ObjectInputStream(new FileInputStream(filename));
            System.out.println("Boolean: " + is.readBoolean());
            System.out.println("Byte: " + is.readByte());
            System.out.println("Short: " + is.readShort());
            System.out.println("Long: " + is.readLong());
            System.out.println("Double: " + is.readDouble());
            is.read(ba2);
            System.out.println("byte array: " + Arrays.toString(ba2));
            System.out.println("Строка: " + is.readUTF());
            try {
                Person person = (Person) is.readObject();
                System.out.println("Object:  " + person);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
