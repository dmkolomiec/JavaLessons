package task2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDAO {
    private int genreId;
    private String Descr;

    public GenreDAO(int genreId, String descr) {
        this.genreId = genreId;
        Descr = descr;
    }

    public GenreDAO(int genreId) throws SQLException {
        try (PreparedStatement statement = DAOFactory.getConnection().prepareStatement("select * from genre where genreId  = ?")) {
            statement.setInt(1, genreId);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new SQLException("Жанр " + genreId + " не знайдений");

            this.genreId = genreId;
            this.Descr = rs.getString("Descr");
        }
    }

    public int getGenreId() {
        return genreId;
    }

    public String getDescr() {
        return Descr;
    }
}
