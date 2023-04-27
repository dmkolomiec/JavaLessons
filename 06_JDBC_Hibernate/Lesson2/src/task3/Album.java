package task3;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Album {
    private HashSet<Track> tracks = new HashSet<>();

    // Добавить 1 трек в альбом
    public boolean addTrack(Track track) {
        return tracks.add(track);
    }

    // Получить общую длительность всех треков в альбоме
    public Time getDuration() {
        return new Time(tracks.stream()
                .map(track -> track.getDuration().getTime())
                .reduce(Long::sum).get());
    }

    // Найти композиции, соответствующуе заданному диапазону длины треков.
    public List<Track> filterTracksByDuration(Time minDuration, Time maxDuration) {
        return tracks.stream()
                .filter(track -> (track.getDuration().getTime() >= minDuration.getTime()
                        && track.getDuration().getTime() <= maxDuration.getTime()))
                .collect(Collectors.toList());
    }

    public void print(String title) {
        System.out.println("\n===== Треки (" + title + ") ======");
        List<Track> list = tracks.stream().sorted().toList();
        for (Track track : list)
            System.out.println(track);
    }
}
