package org.prak.repository;

import org.prak.model.Mob;
import org.prak.repository.base.BaseRepository;

import java.sql.ResultSet;
import java.sql.SQLException;


import static org.prak.util.Constants.SQL_REQUEST_FOR_MOBS;

public class MobsRepository extends BaseRepository<Mob> {

    @Override
    protected String getQuery() {
        return SQL_REQUEST_FOR_MOBS;
    }

    @Override
    protected Mob mapResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String type = rs.getString("type");
        boolean isHostile = rs.getBoolean("is_hostile");
        int biomeId = rs.getInt("biome_id");
        float spawnChance = rs.getFloat("spawn_chance");
        return new Mob(id, name, type, isHostile, biomeId, spawnChance);
    }
}
