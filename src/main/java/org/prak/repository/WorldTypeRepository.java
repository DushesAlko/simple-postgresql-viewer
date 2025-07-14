package org.prak.repository;

import org.prak.model.WorldType;
import org.prak.repository.base.BaseRepository;

import java.sql.ResultSet;
import java.sql.SQLException;


import static org.prak.util.Constants.SQL_REQUEST_FOR_WORLD_TYPES;

public class WorldTypeRepository extends BaseRepository<WorldType> {

    @Override
    protected String getQuery() {
        return SQL_REQUEST_FOR_WORLD_TYPES;
    }

    @Override
    protected WorldType mapResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        return new WorldType(id, name, description);
    }
}
