/** Задание 2
 *  Написать DAO к дополнительному заданию.
 *
 * 5. Звукозапись. Определить иерархию музыкальных композиций.
 *      1. Записать на диск сборку.
 *      2. Подсчитать продолжительность.
 *      3. Провести перестановку композиций диска на основе принадлежности к стилю.
 *      4. Найти композицию, соответствующую заданному диапазону длины треков.
 */
package task2;

import task2.dao.AlbumDAO;
import task2.dao.DAOFactory;
import task2.entity.SortMode;
import task2.entity.Track;

import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AlbumDAO album = DAOFactory.getAlbumDAO();
        album.addTrackById(1);
        album.addTrackById(2);
        album.addTrackById(3);
        album.addTrackById(5);
        album.addTrackById(10);

        album.print("завантажені");

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
        album.save(SortMode.BY_DURATION_DESC);
    }
}
