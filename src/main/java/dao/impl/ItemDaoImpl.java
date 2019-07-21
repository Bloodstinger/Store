package dao.impl;

import dao.ItemDao;
import model.Item;
import org.apache.log4j.Logger;
import utils.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ItemDaoImpl implements ItemDao {

    private static final Logger logger = Logger.getLogger(ItemDaoImpl.class);

    @Override
    public List<Item> getAll() {
        List<Item> itemList = new ArrayList<>();
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items");

            while (resultSet.next()) {
                Item itemFromDb = new Item(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"));
                itemList.add(itemFromDb);
            }
        } catch (SQLException e) {
            logger.error("Problem during getting items from db", e);
        }
        return itemList;
    }

    @Override
    public Item getItem(Long id) {
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items WHERE id=" + id);
            while (resultSet.next()) {
                Item itemFromDb = new Item(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"));
                return itemFromDb;
            }
        } catch (SQLException e) {
            logger.error("Problem while getting item from db", e);
        }
        throw new NoSuchElementException();
    }

    @Override
    public void removeItem(Long id) {
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = String.format("DELETE FROM items WHERE id=%d", id);
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error("Error while removing item from DB", e);
        }
    }

    @Override
    public void replaceItem(Item oldItem, Item newItem) {
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = String.format("UPDATE items SET name='%s', description='%s'," +
                            " price='%.2f' WHERE id= %d",
                    newItem.getName(),
                    newItem.getDescription(),
                    newItem.getPrice(),
                    oldItem.getId());
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error("Problem while replacing item in DB", e);
        }
    }

    @Override
    public void add(Item item) {
        try (Connection connection = DbConnector.connect()) {
            String sql = String.format("INSERT INTO items(name, description, price) VALUES " +
                    "('%s', '%s', %.2f)", item.getName(), item.getDescription(), item.getPrice());
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error("Problem with adding item to DB", e);
        }
    }
}
