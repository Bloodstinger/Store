package dao.impl;

import dao.OrderDao;
import model.Item;
import model.Order;
import model.User;
import org.apache.log4j.Logger;
import utils.DbConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private static final Logger logger = Logger.getLogger(OrderDaoImpl.class);

    @Override
    public void addOrder(Order order) {
        User user = order.getUser();
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = "INSERT "; //FIXME pls
        } catch (SQLException e) {
            logger.error("Error in adding order to db", e);
        }
    }

    @Override
    public List<Item> getItems() {
        return null;
    }
    //TODO add order feature. Order should take shopping cart from session and save items/order
    // details to DB.
}
