package org.prak.repository.base;

import org.prak.database.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<T> {

    protected abstract String getQuery();

    protected abstract T mapResultSet(ResultSet rs) throws SQLException;

    public List<T> getAll() {
        List<T> resultList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(getQuery())) {

            while (rs.next()) {
                resultList.add(mapResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
