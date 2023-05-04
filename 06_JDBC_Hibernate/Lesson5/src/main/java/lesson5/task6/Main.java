/*
    Задание 6
    Из пакета ex_002_insert_and_update создайте в цикле 200 объектов author и сохраните в БД.
    Значения полей могут быть любыми.
    Используйте метод flush для каждых 10 объектов. Метод сommit выполняйте один раз в конце.
 */
package lesson5.task6;

import lesson5.*;

public class Main {
    public static void main(String[] args) {

        HibernateUtil hu = new HibernateUtil("lesson5-persistence-unit");

        AuthorHelper ah = new AuthorHelper(hu);

        ah.addAuthorBulk(202);

        // загрузить авторов из таблицы в список
        System.out.println("===== Список после вставки =====");
        ah.getAuthorList().forEach(System.out::println);

        hu.close();
    }
}
