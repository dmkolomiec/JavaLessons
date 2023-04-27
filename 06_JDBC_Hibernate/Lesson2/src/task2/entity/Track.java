package task2.entity;

import task2.dao.AuthorDAO;
import task2.dao.GenreDAO;

import java.sql.SQLException;
import java.sql.Time;
import java.util.Objects;

public class Track implements Comparable {
    private int trackId;
    private String trackName;
    private int authorId;
    private int genreId;
    private Time duration;

    public static SortMode sortMode = SortMode.BY_TRACKID;

    public Track(int trackId, String trackName, int authorId, int genreId, Time duration) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.authorId = authorId;
        this.genreId = genreId;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return getTrackId() == track.getTrackId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrackId());
    }

    public int getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getGenreId() {
        return genreId;
    }

    public Time getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Object o) {
        return
                switch (Track.sortMode) {
                    case BY_TRACKID -> getTrackId() - ((Track) o).getTrackId();
                    case BY_GENRE -> getGenreId() - ((Track) o).getGenreId();
                    case BY_DURATION_DESC -> ((Track) o).getDuration().getTime() - getDuration().getTime() < 0 ? -1 : 1;
                };
    }

    @Override
    public String toString() {
        try {
            return "" + trackId +
                    ". " + trackName +
                    " (" + new AuthorDAO(authorId).getFullName() +
                    ", " + new GenreDAO(genreId).getDescr() +
                    ", " + duration +
                    ')';
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
