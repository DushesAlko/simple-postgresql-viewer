package org.prak.repository;

import org.prak.model.Biome;
import org.prak.repository.base.BaseRepository;


import java.sql.ResultSet;
import java.sql.SQLException;


import static org.prak.util.Constants.SQL_REQUEST_FOR_BIOMES;

public class BiomesRepository extends BaseRepository<Biome> {

    @Override
    protected String getQuery() {
        return SQL_REQUEST_FOR_BIOMES;
    }

    @Override
    protected Biome mapResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int worldType = rs.getInt("world_type_id");
        float temperature = rs.getFloat("temperature");

        return new Biome(id, name, worldType, temperature);
    }
}
