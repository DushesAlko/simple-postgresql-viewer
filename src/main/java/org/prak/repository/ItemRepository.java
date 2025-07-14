package org.prak.repository;

import org.prak.model.Item;
import org.prak.repository.base.BaseRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.prak.util.Constants.SQL_REQUEST_FOR_ITEMS;

public class ItemRepository extends BaseRepository<Item> {

    @Override
    protected String getQuery() {
        return SQL_REQUEST_FOR_ITEMS;
    }

    @Override
    protected Item mapResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String type = rs.getString("type");
        Short stackSize = (rs.getObject("stack_size") != null) ? rs.getShort("stack_size") : 1;
        Short durability = (rs.getObject("durability") != null) ? rs.getShort("durability") : 1;
        boolean useable = rs.getBoolean("useable");
        Date date = rs.getDate("added_date");
        LocalDate addedDate = date.toLocalDate();

        return new Item(id, name, type, stackSize, durability, useable, addedDate);
    }
}
