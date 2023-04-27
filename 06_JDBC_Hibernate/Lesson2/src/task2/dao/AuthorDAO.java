package task2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
    private int authorId;
    private String fullName;

    public AuthorDAO(int authorId, String fullName) {
        this.authorId = authorId;
        this.fullName = fullName;
    }

    public AuthorDAO(int authorId) throws SQLException {
        try (PreparedStatement statement = DAOFactory.getConnection().prepareStatement("select * from author where authorId  = ?")) {
            statement.setInt(1, authorId);
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new SQLException("Автор  " + authorId + " не знайдений");

            this.authorId = authorId;
            this.fullName = rs.getString("fullName");
        }
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getFullName() {
        return fullName;
    }
}
