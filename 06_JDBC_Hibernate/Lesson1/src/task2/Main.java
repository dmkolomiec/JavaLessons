/**
    Задание 2
    Используя дополнительное задания все вопросы записать в текстовом файле с новой строки каждый и используя потоки ввода-вывода считать с файла все запросы и выполнить.

    В каталоге с проектом должен быть файл MyJoinsDB_Create_and_Fill.sql !!!!
 */
package task2;

public class Main {
    public static void main(String[] args) {

        DBWorker worker = new DBWorker();
        worker.run();
    }
}

