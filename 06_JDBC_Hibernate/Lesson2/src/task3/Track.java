package task3;

import task2.entity.SortMode;

import java.sql.Time;
import java.util.Objects;

public class Track implements Comparable {
    private int trackId;
    private String trackName;
    private String author;
    private String genre;
    private Time duration;

    public static SortMode sortMode = SortMode.BY_TRACKID;

    public Track(int trackId, String trackName, String author, String genre, Time duration) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.author = author;
        this.genre = genre;
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

    public String getAuthor() { return author;}

    public String getGenre() { return genre; }

    public Time getDuration() {
        return duration;
    }

    @Override
    public int compareTo(Object o) {
        return
                switch (Track.sortMode) {
                    case BY_TRACKID -> getTrackId() - ((Track) o).getTrackId();
                    case BY_GENRE -> getGenre().compareTo(((Track) o).getGenre());
                    case BY_DURATION_DESC -> ((Track) o).getDuration().getTime() - getDuration().getTime() < 0 ? -1 : 1;
                };
    }

    @Override
    public String toString() {
            return "" + trackId +
                    ". " + trackName +
                    " (" + author +
                    ", " + genre +
                    ", " + duration +
                    ')';
    }
}
