package org.prak.repository;

import org.prak.database.DatabaseConnector;
import org.prak.model.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import static org.prak.util.Constants.SQL_REQUEST;

public class ItemRepository {
    public static List<Item> getAll() {
        List<Item> listOfItems = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             Statement state = connection.createStatement();
             ResultSet resultSet = state.executeQuery(SQL_REQUEST)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                Short stackSize = (resultSet.getObject("stack_size") != null) ? resultSet.getShort("stack_size") : 1;
                Short durability = (resultSet.getObject("durability") != null) ? resultSet.getShort("durability") : 1;
                boolean useable = resultSet.getBoolean("useable");
                Date date = resultSet.getDate("added_date");
                LocalDate addedDate = date.toLocalDate();
                listOfItems.add(new Item(id, name, type, stackSize, durability, useable, addedDate));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfItems;
    }
}
