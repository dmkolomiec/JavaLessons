/**
 * Задание 3
 * Написать консольное приложение (одно на выбор) из данного списка в книге JAVA_Methods_Programming_v2.march2015 на странице 126, не используя доступа к базе данных и DAO.
 *
 * 5. Звукозапись. Определить иерархию музыкальных композиций.
 *      1. Записать на диск сборку.
 *      2. Подсчитать продолжительность.
 *      3. Провести перестановку композиций диска на основе принадлежности к стилю.
 *      4. Найти композицию, соответствующую заданному диапазону длины треков.
 */
package task3;

import task2.entity.SortMode;

import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Album album = new Album();

        album.addTrack( new Track(1, "Alone (feat. Nicki Minaj)", "Kim Petras", "Pop", Time.valueOf("00:03:06")));
        album.addTrack( new Track(2, "Boat", "Ed Sheeran", "Pop", Time.valueOf("00:03:16")));
        album.addTrack( new Track(3, "Be The One", "Bree Runway", "R&B and soul", Time.valueOf("00:03:19")));
        album.addTrack( new Track(5, "Rescued", "Foo Fighters", "Rock", Time.valueOf("00:04:20")));
        album.print("");
        // 2. Подсчитать продолжительность.
        System.out.println("\nЗагальна тривалість: " + album.getDuration());

        // 4. Найти композицию, соответствующую заданному диапазону длины треков.
        Time t1 = Time.valueOf("00:03:00"),
             t2 = Time.valueOf("00:03:20");

        List<Track> filteredTracks = album.filterTracksByDuration(t1, t2);

        System.out.println("\n===== Треки з тривалістю [" + t1 + ", " + t2 + "] =====");
        filteredTracks.forEach(System.out::println);

        // 3. Провести перестановку композиций диска на основе принадлежности к стилю.
        Track.sortMode = SortMode.BY_GENRE;
        album.print("За жанром");

        // 1. Записать на диск сборку.
        Track.sortMode = SortMode.BY_DURATION_DESC;
        album.print("За зменшенням тривалості");
    }
}
