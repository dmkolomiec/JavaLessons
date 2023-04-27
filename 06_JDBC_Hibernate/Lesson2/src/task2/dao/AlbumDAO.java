package task2.dao;

import task2.entity.SortMode;
import task2.entity.Track;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class AlbumDAO {
    private Connection connection;
    private HashSet<Track> tracks = new HashSet<>();

    // Найти трек по ID
    public Track loadTrackById(int trackID) throws SQLException {
        try (PreparedStatement statement = DAOFactory.getConnection().prepareStatement("select * from track where trackId  = ?")) {
            statement.setInt(1, trackID);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
                return new Track(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getTime(5));
            throw new SQLException("Трек " + trackID + " не найден");
        }
    }

    public boolean addTrackById(int trackId) {
        try {
            return tracks.add(loadTrackById(trackId));
        } catch (SQLException e) {
            return false;
            //throw new RuntimeException(e);
        }
    }

    // Добавить 1 трек в альбом
    public boolean addTrack(Track track) {
        return tracks.add(track);
    }

    // Сохранить треки в БД
    public int save(SortMode sort) {
        Track.sortMode = sort;
        try (Statement ps = DAOFactory.getConnection().createStatement()) {
            ps.addBatch("delete from album");
            int i = 0;
            List<Track> list = tracks.stream().sorted().toList();
            for (Track track : list)
                ps.addBatch(String.format("insert into album values(%d,%d)", track.getTrackId(), ++i));

            int[] res = ps.executeBatch();
            return res.length;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
            //throw new RuntimeException(e);
        }
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
        System.out.println("===== Треки (" + title + ") ======");
        List<Track> list = tracks.stream().sorted().toList();
        for (Track track : list)
            System.out.println(track);
    }
}
